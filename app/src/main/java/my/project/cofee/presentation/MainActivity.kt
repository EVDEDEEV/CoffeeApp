package my.project.cofee.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import my.project.cofee.R
import my.project.cofee.databinding.ActivityMainBinding
import my.project.cofee.presentation.viewModels.CardViewModel
import my.project.cofee.presentation.viewModels.CoffeeViewModel
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    //Подключаем датабайндинг для Main Activity
    private var binding: ActivityMainBinding? = null

    //подключаем di Koin для ViewModel
    private val coffeeViewModel: CoffeeViewModel by viewModel()
    private val cardViewModel: CardViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //Указываем layout для этого активити
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    //Указываем куда нужно мигрировать данные из coffeeViewModel
        coffeeViewModel.migration(this)

    //Байндинг для верхнего меню
        setSupportActionBar(binding?.topMainMenu)

    //Значок количества товаров в корзине на иконках BottomMainMenu
        loadCoffeeToCard()

    //Замена фрагмента main activity на наполнение из фрагмента Home
        supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()

    //Обработка табов по BottomNavigation menu
        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Home()).commit()
                R.id.coffeeBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Coffee()).commit()
                R.id.cardBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Card()).commit()
                R.id.accountBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Account()).commit()
            }
            return@setOnItemSelectedListener true
        }

        binding?.bottomMainMenu?.selectedItemId = R.id.homeBottomMainMenu
    }

    private fun loadCoffeeToCard() {
        cardViewModel.loadCoffeeFromCard
            .observe(this, Observer {

                val count = it.count()

                val badge = binding?.bottomMainMenu?.getOrCreateBadge(R.id.cardBottomMainMenu)

                badge?.isVisible = count > 0
                badge?.number = count
            })


    }


}