package ica.LB;

import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.content.*;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import ica.LB.Core.*;
import com.ica.dice.*;

/**
 * Created by jcapuano on 5/18/2014.
 */
public class FireCombatFragment extends Fragment {
    
    private View rootView;
    
	private Button btnAttackerValuePrev;
	private Button btnAttackerValueNext;
	private EditText editAttackerValue;
	private Button btnAttackerValue4;
	private Button btnAttackerValue6;
	private Button btnAttackerValue9;
	private Button btnAttackerValue12;
	private Button btnAttackerValue16;
	private Button btnAttackerValue18;
	private ToggleButton btnAttackerMod13;
	private ToggleButton btnAttackerMod12;
	private ToggleButton btnAttackerMod32;
	private ToggleButton btnAttackerModCann;
	
	private Button btnDefenderValuePrev;
	private Button btnDefenderValueNext;
	private EditText editDefenderValue;
	
	private Button btnDefenderValue4;
	private Button btnDefenderValue6;
	private Button btnDefenderValue9;
	private Button btnDefenderValue12;
	private Button btnDefenderValue14;
	private Button btnDefenderValue16;
    
	private Button btnDefenderIncrPrev;
	private Button btnDefenderIncrNext;
	private EditText editDefenderIncr;
	
	private ImageView imgFireDie1;
	private ImageView imgFireDie2;
	private ImageView imgFireDie3;
	private ImageView imgFireDie4;
	private ImageView imgFireDie5;
	private Button btnFireDiceRoll;

	private Button btnFireMinus6;
	private Button btnFireMinus3;
	private Button btnFireMinus1;
	private Button btnFirePlus1;
	private Button btnFirePlus3;
	private Button btnFirePlus6;

	private ImageView imgFireResults;
	private TextView txtFireLeaderLoss;
	private ImageView imgFireLeaderLossSide;
	private ImageView imgFireLeaderLoss;
	
	private Spinner spinFireOdds;
	
	private Dice dice;
	private FireCombat fc;
	private Odds odds;
	private PlayAudio audio;

	private double[] defenseValues = new double[] {4,6,7,8,9,10,12,14,16,18};
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView != null) {
            final ViewParent parent = rootView.getParent();
            if (parent != null && parent instanceof ViewGroup)
                ((ViewGroup) parent).removeView(rootView);  
        }
        else {
            dice = new Dice(5, 1, 6);
            fc = new FireCombat();
            odds = fc.getDefaultOdds();
            audio = new PlayAudio (getActivity());

            rootView = inflater.inflate(R.layout.firecombat, container, false);
		
		    // attacker
		    btnAttackerValuePrev = (Button)rootView.findViewById(R.id.btnFireAttackerPrev);
		    btnAttackerValueNext = (Button)rootView.findViewById(R.id.btnFireAttackerNext);
		    editAttackerValue = (EditText)rootView.findViewById(R.id.textFireAttackerValue);
            
            btnAttackerValue4 = (Button)rootView.findViewById(R.id.btnFireAttackerValue4);
            btnAttackerValue6 = (Button)rootView.findViewById(R.id.btnFireAttackerValue6);
            btnAttackerValue9 = (Button)rootView.findViewById(R.id.btnFireAttackerValue9);
            btnAttackerValue12 = (Button)rootView.findViewById(R.id.btnFireAttackerValue12);
            btnAttackerValue16 = (Button)rootView.findViewById(R.id.btnFireAttackerValue16);
            btnAttackerValue18 = (Button)rootView.findViewById(R.id.btnFireAttackerValue18);
            
		    btnAttackerMod13 = (ToggleButton)rootView.findViewById(R.id.btnFireAttacker13);
		    btnAttackerMod12 = (ToggleButton)rootView.findViewById(R.id.btnFireAttacker12);
		    btnAttackerMod32 = (ToggleButton)rootView.findViewById(R.id.btnFireAttacker32);
		    btnAttackerModCann = (ToggleButton)rootView.findViewById(R.id.btnFireAttackerCann);
		
		    // defender
		    btnDefenderValuePrev = (Button)rootView.findViewById(R.id.btnFireDefenderPrev);
		    btnDefenderValueNext = (Button)rootView.findViewById(R.id.btnFireDefenderNext);
		    editDefenderValue = (EditText)rootView.findViewById(R.id.textFireDefenderValue);
        
            btnDefenderValue4 = (Button)rootView.findViewById(R.id.btnFireDefenderValue4);
            btnDefenderValue6 = (Button)rootView.findViewById(R.id.btnFireDefenderValue6);
            btnDefenderValue9 = (Button)rootView.findViewById(R.id.btnFireDefenderValue9);
            btnDefenderValue12 = (Button)rootView.findViewById(R.id.btnFireDefenderValue12);
            btnDefenderValue14 = (Button)rootView.findViewById(R.id.btnFireDefenderValue14);
            btnDefenderValue16 = (Button)rootView.findViewById(R.id.btnFireDefenderValue16);
        
		    btnDefenderIncrPrev = (Button)rootView.findViewById(R.id.btnFireDefenderIncrPrev);
		    btnDefenderIncrNext = (Button)rootView.findViewById(R.id.btnFireDefenderIncrNext);
		    editDefenderIncr = (EditText)rootView.findViewById(R.id.textFireDefenderIncr);
		
		    editAttackerValue.setText("1");
		    editDefenderValue.setText("1");
		    editDefenderIncr.setText("1");
		
		    spinFireOdds = (Spinner)rootView.findViewById(R.id.spinFireOdds);
		
		    imgFireDie1 = (ImageView)rootView.findViewById(R.id.imgFireDie1);
		    imgFireDie2 = (ImageView)rootView.findViewById(R.id.imgFireDie2);
		    imgFireDie3 = (ImageView)rootView.findViewById(R.id.imgFireDie3);
		    imgFireDie4 = (ImageView)rootView.findViewById(R.id.imgFireDie4);
		    imgFireDie5 = (ImageView)rootView.findViewById(R.id.imgFireDie5);
		    btnFireDiceRoll = (Button)rootView.findViewById(R.id.btnFireDiceRoll);
		
		    btnFireMinus6 = (Button)rootView.findViewById(R.id.btnFireMinus6);
		    btnFireMinus3 = (Button)rootView.findViewById(R.id.btnFireMinus3);
		    btnFireMinus1 = (Button)rootView.findViewById(R.id.btnFireMinus1);
		    btnFirePlus1 = (Button)rootView.findViewById(R.id.btnFirePlus1);
		    btnFirePlus3 = (Button)rootView.findViewById(R.id.btnFirePlus3);
		    btnFirePlus6 = (Button)rootView.findViewById(R.id.btnFirePlus6);
        
		    // results
			imgFireResults = (ImageView) rootView.findViewById(R.id.imgResults);
		    imgFireLeaderLossSide = (ImageView)rootView.findViewById(R.id.imgLeaderLossSide);
		    txtFireLeaderLoss = (TextView)rootView.findViewById(R.id.txtLeaderLoss);
		    imgFireLeaderLoss = (ImageView)rootView.findViewById(R.id.imgLeaderLoss);
        
		    // attacker
		    btnAttackerValuePrev.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        double value = getAttackerValue();
			        if (--value < 1) value = 1;
			        editAttackerValue.setText(Double.toString(value));
			        calcOdds();
			        updateResults();
			    }
		    });
        
		    btnAttackerValueNext.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        double value = getAttackerValue();
			        editAttackerValue.setText(Double.toString(++value));
			        calcOdds();
			        updateResults();
			    }
		    });
		    editAttackerValue.addTextChangedListener(new TextWatcher() {
			    @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
			    @Override
                public void onTextChanged(CharSequence s, int start, int before, int end) {
                }
			    @Override
                public void afterTextChanged(Editable s) {
			        calcOdds();
			        updateResults();
                }
            });
        
            btnAttackerValue4.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editAttackerValue.setText(Double.toString(4.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnAttackerValue6.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editAttackerValue.setText(Double.toString(6.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnAttackerValue9.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editAttackerValue.setText(Double.toString(9.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnAttackerValue12.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editAttackerValue.setText(Double.toString(12.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnAttackerValue16.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editAttackerValue.setText(Double.toString(16.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnAttackerValue18.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editAttackerValue.setText(Double.toString(18.0));
			        calcOdds();
			        updateResults();
			    }
		    });
        
        
		    btnAttackerMod13.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        double value = getAttackerValue();
			        if (btnAttackerMod13.isChecked()) {
				        value /= 3;
			        }
			        else {
				        value *= 3;
			        }
			        editAttackerValue.setText(Double.toString(value));
			        calcOdds();
			        updateResults();
			    }
		    });
		    btnAttackerMod12.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        double value = getAttackerValue();
			        if (btnAttackerMod12.isChecked()) {
				        value /= 2;
			        }
			        else {
				        value *= 2;
			        }
			        editAttackerValue.setText(Double.toString(value));
			        calcOdds();
			        updateResults();
			    }
		    });
		    btnAttackerMod32.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        double value = getAttackerValue();
			        if (btnAttackerMod32.isChecked()) {
				        value *= 1.5;
			        }
			        else {
				        value /= 1.5;
			        }
			        editAttackerValue.setText(Double.toString(value));
			        calcOdds();
			        updateResults();
			    }
		    });
		    btnAttackerModCann.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
                    calcOdds();
			        updateResults();
			    }
		    });

		    // defender
		    btnDefenderValuePrev.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        double value = getDefenderValue();
			        value = findNearestDefenseValue(value - 1, true);
			        editDefenderValue.setText(Double.toString(value));
			        calcOdds();
			        updateResults();
			    }
		    });
		    btnDefenderValueNext.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        double value = getDefenderValue();
			        value = findNearestDefenseValue(value + 1, false);
			        editDefenderValue.setText(Double.toString(value));
			        calcOdds();
			        updateResults();
			    }
		    });
		    editDefenderValue.addTextChangedListener(new TextWatcher() {
			    @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
			    @Override
                public void onTextChanged(CharSequence s, int start, int before, int end) {
                }
                public void afterTextChanged(Editable s) {
			        calcOdds();
			        updateResults();
                }
            });
		
        
            btnDefenderValue4.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editDefenderValue.setText(Double.toString(4.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnDefenderValue6.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editDefenderValue.setText(Double.toString(6.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnDefenderValue9.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editDefenderValue.setText(Double.toString(9.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnDefenderValue12.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editDefenderValue.setText(Double.toString(12.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnDefenderValue14.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editDefenderValue.setText(Double.toString(14.0));
			        calcOdds();
			        updateResults();
			    }
		    });
            btnDefenderValue16.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        editDefenderValue.setText(Double.toString(16.0));
			        calcOdds();
			        updateResults();
			    }
		    });
        
		    btnDefenderIncrPrev.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        int value = getDefenderIncrements();
			        if (--value < 1) value = 1;
			        editDefenderIncr.setText(Integer.toString(value));
			        updateResults();
			    }
		    });
		    btnDefenderIncrNext.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        int value = getDefenderIncrements();
			        editDefenderIncr.setText(Integer.toString(++value));
			        updateResults();
			    }
		    });
		    editDefenderIncr.addTextChangedListener(new TextWatcher() {
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
        
		    spinFireOdds.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			        odds = fc.getOddsItem(pos);
			        updateResults();
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });            
        
		    ArrayAdapter<String> adapter = new ArrayAdapter<String> (getActivity(), android.R.layout.simple_spinner_dropdown_item, fc.getOddsList());
		    adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
		    spinFireOdds.setAdapter(adapter);
		
		
		    imgFireDie1.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
                    dice.increment(0);
			        displayDice();
			        updateResults();
			    }
		    });
		    imgFireDie2.setOnClickListener(new OnClickListener() {
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
		    imgFireDie3.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
                    dice.increment(2);
			        displayDice();
			        updateResults();
			    }
		    });
		    imgFireDie4.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
                    dice.increment(3);
			        displayDice();
			        updateResults();
			    }
		    });
		    imgFireDie5.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
                    dice.increment(4);
			        displayDice();
			        updateResults();
			    }
		    });
		
		    btnFireDiceRoll.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        audio.play();
			        dice.roll();
			        displayDice();
			        updateResults();
			    }
		    });
		
		    btnFireMinus6.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(-6);
			        displayDice();
			        updateResults();
			    }
		    });
		    btnFireMinus3.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(-3);
			        displayDice();
			        updateResults();
			    }
		    });
		    btnFireMinus1.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(-1);
			        displayDice();
			        updateResults();
			    }
		    });
		
		    btnFirePlus6.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(6);
			        displayDice();
			        updateResults();
			    }
		    });
		    btnFirePlus3.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(3);
			        displayDice();
			        updateResults();
			    }
		    });
		    btnFirePlus1.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View arg0) {
			        modifyDice(1);
			        displayDice();
			        updateResults();
			    }
		    });
        
		    displayOdds();
		    displayDice();
        }
        
		return rootView;        
    }
    
	void calcOdds() {
		odds = fc.calculate(getAttackerValue(), getDefenderValue(), btnAttackerModCann.isChecked());
		if (odds == null)
			odds = fc.getDefaultOdds();
		displayOdds();
	}
	
	void updateResults() {
		int d = (dice.getDie(0)*10) + dice.getDie(1);
		String result = fc.resolve(odds, getDefenderIncrements(), d);
		//txtFireResults.setText(result, TextView.BufferType.NORMAL);
		if (result == "1") {
			imgFireResults.setImageResource(R.drawable.loss1);
		} else if (result == "2") {
			imgFireResults.setImageResource(R.drawable.loss2);
		} else if (result == "3") {
			imgFireResults.setImageResource(R.drawable.loss3);
		} else if (result == "4") {
			imgFireResults.setImageResource(R.drawable.loss4);
		} else if (result == "5") {
			imgFireResults.setImageResource(R.drawable.loss5);
		} else {
			imgFireResults.setImageResource(R.drawable.loss_ne);
		}

		LeaderLossResult ll = fc.resolveLeaderLoss(d, dice.getDie(2), dice.getDie(3), dice.getDie(4));
		imgFireLeaderLossSide.setVisibility((ll.getKilled() || ll.getWounded() || ll.getCaptured()) ? View.VISIBLE : View.INVISIBLE);
		imgFireLeaderLossSide.setImageResource (ll.getAttacker() ? R.drawable.attacker : R.drawable.defender);
		txtFireLeaderLoss.setVisibility((ll.getKilled() || ll.getWounded() || ll.getCaptured()) ? View.VISIBLE : View.INVISIBLE);
		String loss = ll.getInjury() + (ll.getWounded() ? (" " + Integer.toString(ll.getDuration()) + " hours") : "");
		txtFireLeaderLoss.setText(loss, TextView.BufferType.NORMAL);

		imgFireLeaderLoss.setVisibility((ll.getKilled() || ll.getWounded() || ll.getCaptured()) ? View.VISIBLE : View.INVISIBLE);
		imgFireLeaderLoss.setImageResource(ll.getCaptured() ? R.drawable.capture : (ll.getWounded() ? R.drawable.ambulance : R.drawable.tombstone));
	}
	
	void displayOdds() {
		spinFireOdds.setSelection(fc.getOddsIndex(odds.getName()));
	}

	void displayDice() {
        dice.set(0, DieColor.WHITE_BLACK, imgFireDie1);
		dice.set(1, DieColor.RED_WHITE,   imgFireDie2);
        dice.set(2, DieColor.BLUE_WHITE,  imgFireDie3);
        dice.set(3, DieColor.BLACK_WHITE, imgFireDie4);
        dice.set(4, DieColor.BLACK_RED,   imgFireDie5);
	}

	double getAttackerValue() {
        String v = editAttackerValue.getText().toString();
        if (!v.isEmpty())
            return Double.parseDouble(v);
        return 1;           
	}
	double getDefenderValue() {
        String v = editDefenderValue.getText().toString();
        if (!v.isEmpty())
            return Double.parseDouble(v);
        return 1;           
	}
	int getDefenderIncrements() {
        String v = editDefenderIncr.getText().toString();
        if (!v.isEmpty())
            return Integer.parseInt(v);
        return 1;
	}
	
	double findNearestDefenseValue(double value, boolean neg) {
		if (neg)  {
            for (int i=defenseValues.length-1; i>=0; i--) {
                if (defenseValues[i] <= value) {
                    return defenseValues[i];
                }
            }
            return defenseValues[0];
		}
		
        for (int i=0; i<defenseValues.length; i++) {
            if (defenseValues[i] >= value) {
                return defenseValues[i];
            }
        }
        return defenseValues[defenseValues.length-1];
	}
    
	void modifyDice(int mod) {
		Base6Value b6i = new Base6Value((dice.getDie(0)*10) + dice.getDie(1));
		int value = b6i.add(mod);
		dice.setDie(0, value / 10);
		dice.setDie(1, value % 10);
	}
}