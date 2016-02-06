package com.example.idse.fragmentanimal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class Tab1Fragment extends Fragment{

	private String[] animaux={"Chien", "Chat", "Poisson", "Lapin"};
    private DataTransmit dataTransmit;

    public interface DataTransmit{
        public void transmit(String data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
        final View view=inflater.inflate(R.layout.tab1, container, false);
        final NumberPicker nbrPicker = (NumberPicker)view.findViewById(R.id.nbrPicker);
        nbrPicker.setMinValue(0);
        nbrPicker.setMaxValue(animaux.length - 1);
        nbrPicker.setDisplayedValues(animaux);
        nbrPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                dataTransmit = (DataTransmit)getActivity();
                dataTransmit.transmit(animaux[nbrPicker.getValue()]);
            }
        });
		return view;
	}

}
