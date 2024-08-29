package com.example.olamap

import android.graphics.Point
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.ola.maps.mapslibrary.models.OlaMapsConfig
import androidx.core.view.WindowInsetsCompat
import com.mapbox.mapboxsdk.geometry.LatLng
import com.ola.maps.mapslibrary.models.OlaLatLng
import com.ola.maps.mapslibrary.models.OlaPolylineOptions
import com.ola.maps.mapslibrary.utils.MapTileStyle
import com.ola.maps.navigation.ui.v5.MapStatusCallback
import com.ola.maps.navigation.v5.navigation.OlaMapView

class MainActivity : AppCompatActivity(), MapStatusCallback {
    lateinit var olaMapView : OlaMapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        olaMapView = findViewById(R.id.olaMapView)

        olaMapView?.initialize(
            mapStatusCallback = this,
            olaMapsConfig = OlaMapsConfig.Builder()
                .setApplicationContext(applicationContext) //pass the application context here, it is man
                .setClientId("19533116-e562-47ca-81cf-b0a8bcc78bfe") //pass the Orgination ID here, it is mandatory
                .setMapBaseUrl("https://api.olamaps.io") // pass the Base URL of Ola-Maps here (Stage/Prod URL), it is mandatory
                .setInterceptor (AccessTokenInterceptor()) // Instance of okhttp3.Interceptor for with Bearer
                //.setMapTileStyle (MapTileStyle. <Your Preferred Style) //pass the MapTileStyle here, it is Opti
                //.setUniqueId(<Unique User/Device Id>) //pass the Unique User/Device ID here, it is Optional.
            .setMinZoomLevel(3.8)
            .setMaxZoomLevel(21.0)
            .setZoomLevel(14.0)
            .build()





//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//
//
//
//        }


    }

    override fun onMapReady() {

        Toast.makeText(this@MainActivity, "loaded", Toast.LENGTH_SHORT).show()

        var olapoint = OlaLatLng(13.012746068891305, 77.66342597585445)
        var olapoint2 = OlaLatLng(13.009328854841675, 77.6844361035776)

        var markerpoint = LatLng(13.012746068891305, 77.66342597585445)
        var point = com.mapbox.geojson.Point.fromLngLat(markerpoint.longitude, markerpoint.longitude)

        olaMapView.addMarker(point)

        var polylineOptions = OlaPolylineOptions.Builder()
            .setPoints(arrayListOf(olapoint,olapoint2))
            .setColor("#FF0000")
            .setWidth(5f)
            .build()
    }

    override fun onMapLoadFailed(p0: String?) {
        TODO("Not yet implemented")
    }
}