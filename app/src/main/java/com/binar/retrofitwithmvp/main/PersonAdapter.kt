package com.binar.retrofitwithmvp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.retrofitwithmvp.R
import com.binar.retrofitwithmvp.pojo.GetPersonsResponse
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter(var listPerson: List<GetPersonsResponse.Result>, val presenter: MainPresenter) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tvID.text = listPerson[position].iD.toString()
        holder.itemView.tvCreatedAt.text = listPerson[position].createdAt
        holder.itemView.tvUpdatedAt.text = listPerson[position].updatedAt
        holder.itemView.tvDeletedAt.text = "Deleted At : ${listPerson[position].deletedAt} "
        holder.itemView.tvFirstName.text = listPerson[position].firstName
        holder.itemView.tvLastName.text = listPerson[position].lastName
        holder.itemView.setOnClickListener {
            presenter.goToUpdateActivity(listPerson[position])
        }

        holder.itemView.ivDelete.setOnClickListener {
            presenter.deletePerson(listPerson[position])
        }
    }


}