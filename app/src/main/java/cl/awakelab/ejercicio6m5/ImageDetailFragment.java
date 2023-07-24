package cl.awakelab.ejercicio6m5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

import cl.awakelab.ejercicio6m5.databinding.FragmentImageDetailBinding;

public class ImageDetailFragment extends Fragment {
    private static final String ARG_ITEM = "item";
    private Item item;
    private FragmentImageDetailBinding binding;

    public static ImageDetailFragment newInstance(Item item) {
        ImageDetailFragment fragment = new ImageDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable(ARG_ITEM);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentImageDetailBinding.inflate(inflater, container, false);
        binding.btnBack.setOnClickListener(v -> {
            back();
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if (item != null) {
            binding.tvItemName.setText(item.getName());
            Glide.with(requireContext())
                    .load(item.getImageUrl())
                    .into(binding.ivItemImage);
        }
    }
    private void back(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack();
    }

}
