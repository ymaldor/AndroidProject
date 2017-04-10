package projet.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by alex on 06/04/2017.
 */

public class FormFragment extends Fragment {
    public FormFragment(){}





    private FormFragment.OnFragmentInteractionListener mListener;


    Button addcourse;
    EditText disttxt;
    EditText loctxt;
    EditText logtxt;
    EditText lattxt;
    EditText timtxt;
    String tmp;

    public static FormFragment newInstance() {
        FormFragment fragment = new FormFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.form_fragment, container,
                false);
        disttxt=(EditText)getView().findViewById(R.id.distance);
        loctxt=(EditText)getView().findViewById(R.id.localisation);
        logtxt=(EditText)getView().findViewById(R.id.longitude);
        timtxt=(EditText)getView().findViewById(R.id.temps);
        lattxt=(EditText)getView().findViewById(R.id.latitude);
        addcourse=(Button)view.findViewById(R.id.Addbtn);
        addcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int distance=-1;distance=Integer.parseInt(disttxt.getText().toString());
                String localisation="";localisation=loctxt.getText().toString();
                int longitude=-1;longitude=Integer.parseInt(logtxt.getText().toString());
                int latitude=-1;latitude=Integer.parseInt(lattxt.getText().toString());
                double temps=-1;temps=Double.parseDouble(timtxt.getText().toString());
                if(distance==-1 && localisation=="" && longitude==-1 && latitude==-1 && temps==-1) {
                    Course course = new Course(distance, temps, localisation, longitude, latitude);
                    DataBaseHelper dbHandler=new DataBaseHelper(getActivity());
                    dbHandler.addCourse(course);
                    disttxt.setText("");
                    loctxt.setText("");
                    logtxt.setText("");
                    timtxt.setText("");
                    lattxt.setText("");
                }


            }});

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        // Refresh the state of the +1 button each time the activity receives focus.
        //mPlusOneButton.initialize(PLUS_ONE_URL, PLUS_ONE_REQUEST_CODE);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FormFragment.OnFragmentInteractionListener) {
            mListener = (FormFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        //TODO: Update argument type and name
        void onFragmentInteraction(Object ref);
    }
}
