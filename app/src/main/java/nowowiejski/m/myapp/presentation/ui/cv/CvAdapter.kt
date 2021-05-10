package nowowiejski.m.myapp.presentation.ui.cv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import nowowiejski.m.myapp.R
import nowowiejski.m.myapp.core.extensions.executeAfter
import nowowiejski.m.myapp.databinding.*
import nowowiejski.m.myapp.domain.model.Address
import nowowiejski.m.myapp.domain.model.Education
import nowowiejski.m.myapp.domain.model.Experience
import nowowiejski.m.myapp.domain.model.User
import nowowiejski.m.myapp.presentation.model.MyCvDisplayable

class CvAdapter : RecyclerView.Adapter<CvViewHolder>() {

    private val differ = AsyncListDiffer(this, DiffCallback)

    private var listener: ((MyCvDisplayable) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CvViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_user -> CvViewHolder.UserViewHolder(
                ItemUserBinding.inflate(inflater, parent, false)
            )
            R.layout.item_address -> CvViewHolder.AddressViewHolder(
                ItemAddressBinding.inflate(inflater, parent, false)
            )
            R.layout.item_education -> CvViewHolder.EducationViewHolder(
                ItemEducationBinding.inflate(inflater, parent, false)
            )
            R.layout.item_experience -> CvViewHolder.ExperienceViewHolder(
                ItemExperienceBinding.inflate(inflater, parent, false)
            )
            else -> throw IllegalStateException("Unknown viewType $viewType")
        }
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: CvViewHolder, position: Int) {
        when (holder) {
            is CvViewHolder.UserViewHolder -> holder.binding.executeAfter {
                user = differ.currentList[position] as User
            }
            is CvViewHolder.AddressViewHolder -> holder.binding.executeAfter {
                address = differ.currentList[position] as Address
            }
            is CvViewHolder.EducationViewHolder -> holder.binding.executeAfter {
                education = differ.currentList[position] as Education
            }
            is CvViewHolder.ExperienceViewHolder -> holder.binding.executeAfter {
                experience = differ.currentList[position] as Experience
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (differ.currentList[position]) {
            is User -> R.layout.item_user
            is Education -> R.layout.item_education
            is Address -> R.layout.item_address
            is Experience -> R.layout.item_experience
            else -> throw IllegalStateException("Unknown view type at position $position")
        }
    }

    fun setOnClickListener(listener: (MyCvDisplayable) -> Unit) {
        this.listener = listener
    }

    fun setData(myCvDisplayable: MyCvDisplayable) {
        differ.submitList(buildMergedList(myCvDisplayable))
        notifyDataSetChanged()
    }

    private fun buildMergedList(
        item: MyCvDisplayable
    ): List<Any> {
        val merged = mutableListOf<Any>()
        merged.add(item.user)
        merged.add(item.address)
        merged.add(item.education)
        merged.addAll(item.experienceList)
        return merged
    }
}

sealed class CvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class UserViewHolder(
        val binding: ItemUserBinding
    ) : CvViewHolder(binding.root)

    class EducationViewHolder(
        val binding: ItemEducationBinding
    ) : CvViewHolder(binding.root)

    class AddressViewHolder(
        val binding: ItemAddressBinding
    ) : CvViewHolder(binding.root)

    class ExperienceViewHolder(
        val binding: ItemExperienceBinding
    ) : CvViewHolder(binding.root)
}

object DiffCallback : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is User && newItem is User -> oldItem == newItem
            oldItem is Address && newItem is Address -> oldItem == newItem
            oldItem is Education && newItem is Education -> oldItem == newItem
            oldItem is Experience && newItem is Experience -> oldItem == newItem
            else -> false
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is User && newItem is User -> oldItem == newItem
            else -> true
        }
    }
}