package cl.awakelab.ejercicio6m5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cl.awakelab.ejercicio6m5.databinding.FragmentImageListBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageListFragment extends Fragment implements ItemAdapter.OnItemClickListener {
    private List<Item> itemList;
    private FragmentImageListBinding binding;

    public static ImageListFragment newInstance() {
        return new ImageListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemList = returnItemList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentImageListBinding.inflate(inflater, container, false);
        setupRecyclerView();
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        ItemAdapter adapter = new ItemAdapter(requireContext(), itemList, this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Item item) {
        ImageDetailFragment detailFragment = ImageDetailFragment.newInstance(item);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, detailFragment)
                .addToBackStack(null)
                .commit();
    }

    private List<Item> returnItemList() {
        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item("Zhuo Cheng you", "https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640"));
        listItem.add(new Item("billow926", "https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640"));
        listItem.add(new Item("Philipp Deiß", "https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640"));
        listItem.add(new Item("Huper by Joshua Earle", "https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640"));
        listItem.add(new Item("Melnychuk Nataliya", "https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640"));
        listItem.add(new Item("Teagan Maddux", "https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640"));
        listItem.add(new Item("Chen Liu", "https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640"));
        listItem.add(new Item("John Fornander", "https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640"));
        listItem.add(new Item("Parker Coffman", "https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640"));
        listItem.add(new Item("XPS", "https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640"));
        listItem.add(new Item("Daniel J. Schwarz", "https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640"));
        listItem.add(new Item("Wesley Armstrong", "https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640"));
        return listItem;
    }
}