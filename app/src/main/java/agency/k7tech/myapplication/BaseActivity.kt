package agency.k7tech.myapplication

import agency.k7tech.myapplication.adapters.RecyclerViewAdapter
import agency.k7tech.myapplication.models.CardViewInfo
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.leinardi.android.speeddial.SpeedDialActionItem
import kotlinx.android.synthetic.main.activity_base.*


class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(myToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        title = ""
        floatingActionButton.addActionItem(
                SpeedDialActionItem.Builder(R.id.fab_link, R.drawable.ic_plus)
                        .create()
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(
                arrayListOf(CardViewInfo(R.drawable.image1, getString(R.string.loremIpsum))
                        , CardViewInfo(R.drawable.image2, getString(R.string.loremIpsum))
                        , CardViewInfo(R.drawable.image3, getString(R.string.loremIpsum)))
                , this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
