package cecilia.moron.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        val url = "https://www.google.com"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.d( "Respuesta", "${response.substring(0,500)}")
                // Display the first 500 characters of the response string.
                mostrarRespuesta.text = "Respuesta es: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { error ->
                mostrarRespuesta.text = "Error: ${error.message}"
                Log.d("Error", "${error.message}")
            })


        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}
