package com.example.mycontextmenu2

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listView) as ListView
        val itemsArray = arrayOf("Item 1","Item 2")
        val itemAdapter: ArrayAdapter<String> =
            ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,itemsArray)

        listView.adapter = itemAdapter
        registerForContextMenu(listView)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu!!.setHeaderTitle("Select item")

        menu.add(0,v!!.id,0,"Sub Item 1")
        menu.add(0,v!!.id,0,"Sub Item 2")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if(item!!.title == "Sub Item 1"){
            Toast.makeText(this@MainActivity, "Sub 1 Clicked",Toast.LENGTH_LONG).show()
        }else if(item!!.title == "Sub Item 2"){
            Toast.makeText(this@MainActivity, "Sub 2 Clicked",Toast.LENGTH_LONG).show()
        }
        return super.onContextItemSelected(item)
    }
}