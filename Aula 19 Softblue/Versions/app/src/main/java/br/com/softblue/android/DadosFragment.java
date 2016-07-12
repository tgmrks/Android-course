package br.com.softblue.android;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DadosFragment extends Fragment {
	
	private int layoutId;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(layoutId, container, false);
	}

	public DadosFragment setLayoutId(int layoutId) {
		this.layoutId = layoutId;
		return this;
	}
}
