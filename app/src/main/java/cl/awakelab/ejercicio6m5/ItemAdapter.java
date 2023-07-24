package cl.awakelab.ejercicio6m5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import cl.awakelab.ejercicio6m5.databinding.ItemLayoutBinding;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Item> itemList;
    private Context context;
    private OnItemClickListener itemClickListener;

    public ItemAdapter(Context context, List<Item> itemList, OnItemClickListener itemClickListener){
        this.context = context;
        this.itemList =itemList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ItemLayoutBinding binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {

        return itemList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(Item item);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ItemLayoutBinding binding;
        ItemViewHolder(ItemLayoutBinding binding){
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION){
                    Item item = itemList.get(position);
                    itemClickListener.onItemClick(item);
                }
            });
        }

        void bind(Item item){
            binding.tvItemName.setText(item.getName());
            Glide.with(context)
                    .load(item.getImageUrl())
                    .into(binding.ivItemImage);

        }
    }
}

