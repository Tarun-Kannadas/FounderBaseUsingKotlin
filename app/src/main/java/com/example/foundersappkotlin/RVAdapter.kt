package com.example.foundersappkotlin

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RVAdapter(
    private val context: Context,
    private val founderList: List<FounderDetails>
):RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val founderImg: ImageView = view.findViewById(R.id.founder_img)
        val founderName: TextView = view.findViewById(R.id.founder_heading)
        val founderDesc: TextView = view.findViewById(R.id.founder_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.founders_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = founderList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val founder = founderList[position]
        holder.founderName.text = founder.name
        holder.founderDesc.text = founder.desc
        holder.founderImg.setImageResource(founder.imgId)

        val clickListener = View.OnClickListener{
            val intent = Intent(context, FoundersBrief::class.java)
            intent.putExtra("founderData", founder)
//            context.startActivity(intent)

            val options = ActivityOptions.makeCustomAnimation(
                context,
                R.anim.slide_in,
                R.anim.slide_out
            )

            context.startActivity(intent, options.toBundle())

        }

        holder.founderImg.setOnClickListener(clickListener)
        holder.founderName.setOnClickListener(clickListener)
        holder.founderDesc.setOnClickListener(clickListener)
    }
}
