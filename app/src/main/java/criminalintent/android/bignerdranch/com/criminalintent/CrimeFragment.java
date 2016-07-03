package criminalintent.android.bignerdranch.com.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Cavid on 4/24/2016.
 */
public class CrimeFragment extends Fragment {
    public static final String EXTRA_CRIME_ID = "criminalintent.android.bignerdranch.com.criminalintent.crime_id";

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args= new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID crimeId =(UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState ){
        View v =inflater.inflate(R.layout.fragment_crime,parent,false);
        mTitleField =(EditText) v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());
        mCrime = new Crime();

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence c, int start, int before, int after) {
                mCrime.setTitle(c.toString());
            }
            @Override
            public void beforeTextChanged(CharSequence c, int start, int before, int count) {
                //This space intentionally left blank
            }
            @Override
            public void afterTextChanged(Editable c) {
                //This one too

            }
        });

        android.text.format.DateFormat df = new android.text.format.DateFormat();

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        mDateButton.setText(df.format("EEE, MMM dd yyyy", mCrime.getDate()).toString());
        mDateButton.setEnabled(true);

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //set The Crime's solved property
                mCrime.setSolved(isChecked);
            }
        });


        return v;
    }

}
