package com.sbs.administrator.sribalajisociety;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private Button btnLogin;


    private Button btnLinkToRegister,btnforgetpwd,btnguest;
    private EditText inputEmail;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        btnforgetpwd=(Button)findViewById(R.id.btnLinkToForgotpwd);
        btnguest=(Button)findViewById(R.id.btnguestlogin);
        btnguest.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(getApplicationContext(),
                                                    AndroidGridLayout.class);
                                            startActivity(i);
                                            finish();
                                        }
                                    });

                btnforgetpwd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(),
                                ForgotActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);


        // SQLite database handler good
        db = new SQLiteHandler(getApplicationContext());


        // Session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not   YES YES shall i run now my app and check it it again coming splash and login i have already login once na at time of installing
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
          /* Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();*/
        }

        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    hideDialog();
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }
            }

        });

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    /**
     * function to verify login details in mysql db
     * */
    private void checkLogin(final String email,final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        //CALL SERVICE LOGIN
        StringRequest strReq = new StringRequest(Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                //VALID RESPONSE
                if(!response.isEmpty()){
                    // TODO INIT PROCESS VALID RESPONSE SERVICE
                    try {
                        JSONObject jObj = new JSONObject(response);
                        boolean error = jObj.getBoolean("error");
                        if (!error) {
                            //FLOW ERROR == FLASE
                            // Create login session
                            session.setLogin(true);

                            //

                            // Now store the user in SQLite
                          //  String uid = jObj.getString("uid");

                            //Now store the user in SQLiteString uid = jObj.getString("uid");
                            //TODO VALIDATION IF KEY "USER" EXIST INTO JSON
                            if(jObj.has("user")){
                                JSONObject user = jObj.getJSONObject("user");

                                //VALIDATION SIMPLE KEY
                                if(user.has("fname")){
                                    String name = user.getString("fname");
                                }
                                if(user.has("lname")){
                                    String lastname=user.getString("lname");
                                }

                                if(user.has("email")){
                                    String email = user.getString("email");
                                }
                                if(user.has("password")){
                                    String pwd=user.getString("password");
                                }




                            hideDialog();
                                //TODO SO THAT IT SERVES THE PORPUSE USER ?
                                Intent intent = new Intent(LoginActivity.this,
                                        AndroidGridLayout.class);
                                startActivity(intent);
                                finish();

                            }



                        }
                        else {
                            hideDialog();
                            // Error in login. Get the error message
                            String errorMsg = jObj.getString("error_msg");
                            Toast.makeText(getApplicationContext(),
                                    errorMsg, Toast.LENGTH_LONG).show();
                        }/*else{
                            //FLOW ERROR == TRUE
                            hideDialog();
                        }*/

                    }catch (JSONException e){
                        //TODO RETRY LOGIN
                        hideDialog();
                        Log.d("TAG1111", "Login Response: " + e.getMessage());
                    }
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                HashMap<String, String> params = new HashMap<String, String>();

                params.put("email", email);
                params.put("password", password);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
