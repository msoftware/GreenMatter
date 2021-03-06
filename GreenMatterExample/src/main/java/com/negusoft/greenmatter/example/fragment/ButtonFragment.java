package com.negusoft.greenmatter.example.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListPopupWindow;
import android.widget.QuickContactBadge;

import com.negusoft.greenmatter.example.R;
import com.negusoft.greenmatter.widget.MatImageButton;

public class ButtonFragment extends Fragment {
	
	private View mListPopupButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.buttons, null);
		
		View coloredButton = result.findViewById(R.id.coloredButton);
		coloredButton.setLongClickable(true);
//		registerForContextMenu(coloredButton);
		
//		mListPopupButton = result.findViewById(R.id.listPopupButton);
//		mListPopupButton.setOnLongClickListener(mPopupListener);

        // Test MatButton.setColor()
//        if (coloredButton instanceof MatButton) {
//            ((MatButton)coloredButton).setColor(Color.BLUE);
//        }
		
		return result;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		if (v.getId() == R.id.coloredButton) {
			MenuInflater inflater = getActivity().getMenuInflater();
			inflater.inflate(R.menu.spinner, menu);
		}
	}
	
	@SuppressWarnings("unused")
	private View.OnLongClickListener mPopupListener = new View.OnLongClickListener() {
		@Override public boolean onLongClick(View v) {
			String[] versions = { "Camera", "Laptop", "Watch", "Smartphone",
					"Television" };
			final ListPopupWindow listPopupWindow = new ListPopupWindow(
					getActivity());
			listPopupWindow.setAdapter(new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_dropdown_item_1line, versions));
			listPopupWindow.setAnchorView(mListPopupButton);
			listPopupWindow.setWidth(300);
			listPopupWindow.setHeight(400);

			listPopupWindow.setModal(true);
			listPopupWindow.show();
			return false;
		}
	};

}
