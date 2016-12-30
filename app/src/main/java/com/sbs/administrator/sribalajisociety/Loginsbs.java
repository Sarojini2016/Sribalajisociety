package com.sbs.administrator.sribalajisociety;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Loginsbs extends Activity {
	Button login,guest;
	TextView tvforgetpwd,tvreg;
	EditText edemail,edpassword;
   // private DatabaseHelper db;
   /* private ProgressDialog pDialog;
    private SessionManager session;*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loginsbs);


		edemail = (EditText) findViewById(R.id.email);
	     //edemail.setTypeface(tf1);
	     edpassword= (EditText) findViewById(R.id.password);
	    // edpassword.setTypeface(tf1);
	     guest=(Button)findViewById(R.id.btnalogin);
	     guest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentSignUP=new Intent(getApplicationContext(),AndroidGridLayout.class);
				startActivity(intentSignUP);
			
				
			}
		});

	     Resources resources = getResources();

	        String string = resources.getString(R.string.forgot);

	     tvforgetpwd=(TextView)findViewById(R.id.tvlink);
	     tvforgetpwd.setText(string);
	     tvforgetpwd.setOnClickListener(new  View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				}
			
		});
	
	     /*login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }
			}
		});*/

	    tvreg=(TextView)findViewById(R.id.tvregister);
//	     tvreg.setLines(TRIM_MEMORY_COMPLETE);

			//tvreg.setTypeface(tf1);
			
	    // Set OnClick Listener on SignUp button 
	    tvreg.setOnClickListener(new View.OnClickListener() 
	    {
		public void onClick(View v)
		{
			Intent i = new Intent(getApplicationContext(),
					RegisterActivity.class);
			startActivity(i);
			finish();
			
			/// Create Intent for SignUpActivity  and Start The Activity
			/*Intent intentSignUP=new Intent(getApplicationContext(),Registrationform.class);
			startActivity(intentSignUP);*/
		
		}
	
	    });
	
	}

	/*private void checkLogin(final String email, final String password) {
		// Tag used to cancel the request
		String tag_string_req = "req_login";

		pDialog.setMessage("Logging in ...");
		showDialog();

		StringRequest strReq = new StringRequest(Request.Method.POST,
				AppConfig.URL_LOGIN, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.d("TAG1111", "Login Response: " + response.toString());
				hideDialog();

				try {
					JSONObject jObj = new JSONObject(response);
					boolean error = jObj.getBoolean("error");

					// Check for error node in json
					if (!error) {
						// user successfully logged in
						// Create login session
						session.setLogin(true);

						// Now store the user in SQLite
						//  String uid = jObj.getString("uid");

						JSONObject user = jObj.getJSONObject("user");
						String name = user.getString("name");
						String lastname=user.getString("lname");
						String username=user.getString("uname");
						String email = user.getString("email");
						String pwd=user.getString("password");


						// Launch main activity
						Intent intent = new Intent(LoginActivity_OLD.this,
								MainActivity.class);
						startActivity(intent);
						finish();
					} else {
						// Error in login. Get the error message
						String errorMsg = jObj.getString("error_msg");
						Toast.makeText(getApplicationContext(),
								errorMsg, Toast.LENGTH_LONG).show();
					}
				} catch (JSONException e) {
					// JSON error
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
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
				Map<String, String> params = new HashMap<String, String>();
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
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loginsbs, menu);
		return true;
	}

}
