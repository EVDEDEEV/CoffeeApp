package my.project.cofee.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.cofee.R
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.CoffeeModel
import my.project.cofee.databinding.CoffeeItemBinding

class CoffeeAdapter(
    private val addToCard: (CoffeeModel) -> Unit,
    private val removeFromCard: (CoffeeModel) -> Unit,
    private val loadCoffeeToCardFromCardProduct:(Int, AppCompatImageButton, AppCompatImageButton)-> Unit):
        RecyclerView.Adapter<CoffeeAdapter.CoffeeHolder>()

{

    private val coffee = ArrayList<CoffeeModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CoffeeItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.coffee_item, parent, false)
        return CoffeeHolder(binding)
    }

    override fun getItemCount(): Int {
        return coffee.size
    }


    override fun onBindViewHolder(holder: CoffeeHolder, position: Int) {
        holder.bind(coffee[position], addToCard, removeFromCard, loadCoffeeToCardFromCardProduct)

    }

    fun setList(coffeeList: List<CoffeeModel>) {
        coffee.clear()
        coffee.addAll(coffeeList)

    }


    class CoffeeHolder(val binding: CoffeeItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(
            coffeeModel: CoffeeModel, addToCard: (CoffeeModel) -> Unit,
            removeFromCard: (CoffeeModel) -> Unit,
            loadCoffeeToCardFromCardProduct: (Int, AppCompatImageButton, AppCompatImageButton) -> Unit
        ) {

            val getImage = coffeeModel.image
            Picasso.get().load(getImage).into(binding.imageCoffee)
            binding.nameCoffee.text = coffeeModel.name
            binding.descriptionCoffee.text = coffeeModel.description
            binding.priceCoffee.text = coffeeModel.price

            binding?.addToCard?.setOnClickListener(View.OnClickListener {
                addToCard(coffeeModel)
            })

            binding?.removeFromCard?.setOnClickListener(View.OnClickListener {
                removeFromCard(coffeeModel)
            })

            loadCoffeeToCardFromCardProduct(coffeeModel.id, binding.addToCard, binding.removeFromCard)

        }

    }

}