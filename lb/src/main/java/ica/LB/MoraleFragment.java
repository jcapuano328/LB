package ica.LB;

import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.content.*;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.*;

import ica.LB.Core.*;
import com.ica.dice.*;

/**
 * Created by jcapuano on 5/24/2014.
 */
public class MoraleFragment extends Fragment {

    private View rootView;
	
	private Button btnMoralePrev;
	private Button btnMoraleNext;
	private EditText editMoraleValue;

	private Button btnMoraleValue16;
	private Button btnMoraleValue26;
	private Button btnMoraleValue36;
	private Button btnMoraleValue46;
	private Button btnMoraleValue56;
	private Button btnMoraleValue66;
	
	private ImageView imgMoraleDie1;
	private ImageView imgMoraleDie2;
	private Button btnMoraleDiceRoll;

	private Button btnMoraleMinus6;
	private Button btnMoraleMinus3;
	private Button btnMoraleMinus1;
	private Button btnMoralePlus1;
	private Button btnMoralePlus3;
	private Button btnMoralePlus6;
	
	private TextView txtMoraleResults;
	
	private Dice dice;
	private Morale morale;
	private PlayAudio audio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView != null) {
            final ViewParent parent = rootView.getParent();
            if (parent != null && parent instanceof ViewGroup)
                ((ViewGroup) parent).removeView(rootView);  
        }
        else {
            dice = new Dice(2, 1, 6);
            morale = new Morale();
            audio = new PlayAudio (getActivity());

            rootView = inflater.inflate(R.layout.morale, container, false);
    
		    btnMoralePrev = (Button)rootView.findViewById(R.id.btnMoralePrev);
		    btnMoraleNext = (Button)rootView.findViewById(R.id.btnMoraleNext);
		    editMoraleValue = (EditText)rootView.findViewById(R.id.editMoraleValue);
		
		    editMoraleValue.setText("11");
            
            btnMoraleValue16 = (Button)rootView.findViewById(R.id.btnMoraleValue16);
            btnMoraleValue26 = (Button)rootView.findViewById(R.id.btnMoraleValue26);
            btnMoraleValue36 = (Button)rootView.findViewById(R.id.btnMoraleValue36);
            btnMoraleValue46 = (Button)rootView.findViewById(R.id.btnMoraleValue46);
            btnMoraleValue56 = (Button)rootView.findViewById(R.id.btnMoraleValue56);
            btnMoraleValue66 = (Button)rootView.findViewById(R.id.btnMoraleValue66);
		
		    imgMoraleDie1 = (ImageView)rootView.findViewById (R.id.imgMoraleDie1);
		    imgMoraleDie2 = (ImageView)rootView.findViewById (R.id.imgMoraleDie2);
		    btnMoraleDiceRoll = (Button)rootView.findViewById(R.id.btnMoraleDiceRoll);
		
		    btnMoraleMinus6 = (Button)rootView.findViewById(R.id.btnMoraleMinus6);
		    btnMoraleMinus3 = (Button)rootView.findViewById(R.id.btnMoraleMinus3);
		    btnMoraleMinus1 = (Button)rootView.findViewById(R.id.btnMoraleMinus1);
		    btnMoralePlus1 = (Button)rootView.findViewById(R.id.btnMoralePlus1);
		    btnMoralePlus3 = (Button)rootView.findViewById(R.id.btnMoralePlus3);
		    btnMoralePlus6 = (Button)rootView.findViewById(R.id.btnMoralePlus6);
		
		    txtMoraleResults = (TextView)rootView.findViewById(R.id.txtMoraleResults);
        
		    btnMoralePrev.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        Base6Value b6i = new Base6Value(getMoraleValue());
			        int value = b6i.subtract(1);
			        editMoraleValue.setText(Integer.toString(value));
                    updateResults();
			    }
		    });
		    btnMoraleNext.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        Base6Value b6i = new Base6Value(getMoraleValue());
			        int value = b6i.add(1);
			        editMoraleValue.setText(Integer.toString(value));
                    updateResults();
			    }
		    });
		    editMoraleValue.addTextChangedListener(new TextWatcher() {
			    @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
			    @Override
                public void onTextChanged(CharSequence s, int start, int before, int end) {
                }
			    @Override
                public void afterTextChanged(Editable s) {
			        updateResults();
                }
            });


            btnMoraleValue16.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editMoraleValue.setText("16");
                    updateResults();
			    }
		    });
            btnMoraleValue26.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editMoraleValue.setText("26");
                    updateResults();
			    }
		    });
            btnMoraleValue36.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editMoraleValue.setText("36");
                    updateResults();
			    }
		    });
            btnMoraleValue46.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editMoraleValue.setText("46");
                    updateResults();
			    }
		    });
            btnMoraleValue56.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editMoraleValue.setText("56");
                    updateResults();
			    }
		    });
            btnMoraleValue66.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editMoraleValue.setText("66");
                    updateResults();
			    }
		    });
        
		
		    imgMoraleDie1.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
                    dice.increment(0);
			        displayDice();
			        updateResults();
			    }
		    });
		    imgMoraleDie2.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
                    if (dice.getDie(1) == 6) {
                        dice.increment(0);
                    }
                    dice.increment(1);
			        displayDice();
			        updateResults();
			    }
		    });
		
		    btnMoraleDiceRoll.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        audio.play();
			        dice.roll();
			        displayDice();
			        updateResults();
			    }
		    });
		
		    btnMoraleMinus6.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(-6);
			        displayDice();
			        updateResults();
			    }
		    });
		    btnMoraleMinus3.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(-3);
			        displayDice();
			        updateResults();
			    }
		    });
		    btnMoraleMinus1.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(-1);
			        displayDice();
			        updateResults();
			    }
		    });
		
		    btnMoralePlus6.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(6);
			        displayDice();
			        updateResults();
			    }
		    });
		    btnMoralePlus3.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(3);
			        displayDice();
			        updateResults();
			    }
		    });
		    btnMoralePlus1.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(1);
			        displayDice();
			        updateResults();
			    }
		    });
        }

        return rootView;
	}

	void updateResults() {
		int d = (dice.getDie(0)*10) + dice.getDie(1);
		String result = morale.resolve(getMoraleValue(), d);
		txtMoraleResults.setText(result, TextView.BufferType.NORMAL);
	}
	
	void displayDice() {
        dice.set(0, DieColor.WHITE_BLACK, imgMoraleDie1);
		dice.set(1, DieColor.RED_WHITE,   imgMoraleDie2);
	}

	int getMoraleValue() {
        String v = editMoraleValue.getText().toString();
        if (!v.isEmpty())
            return Integer.parseInt(v);
        return 11;
	}
	
	void modifyDice(int mod) {
		Base6Value b6i = new Base6Value((dice.getDie(0)*10) + dice.getDie(1));
		int value = b6i.add(mod);
		dice.setDie(0, value / 10);
		dice.setDie(1, value % 10);
	}
}