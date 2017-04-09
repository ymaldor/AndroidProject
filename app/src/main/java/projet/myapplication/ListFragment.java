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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by alex on 06/04/2017.
 */

public class ListFragment extends Fragment{
    public ListFragment(){}


    TableLayout Table;
    Vector<Course> courses;
    int i;


    private OnFragmentInteractionListener mListener;



    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
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
        View view = inflater.inflate(R.layout.list_fragment, container,
                false);
        Course course;
        Context context=getActivity();
        DataBaseHelper help=new DataBaseHelper(context);
        courses=help.getCourses();
        TextView text;
        TableRow row;
        String tmp;
        TableLayout tl = (TableLayout)view.findViewById(R.id.table);
        Button btn;

        for(i=0;i<courses.size();i++)
        {
            row=new TableRow(getActivity());
            text=new TextView(getActivity());
            text.setText(courses.get(i).getdist());
            row.addView(text);
            tmp=Double.toString(courses.get(i).getTime());
            text.setText(tmp);
            row.addView(text);
            text.setText(courses.get(i).getLocation());
            row.addView(text);
            btn=new Button(getActivity());
            btn.setId(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getActivity()).gotomaps(courses.get(i));
                };});
            row.addView(btn);
            tl.addView(row,i);
        }

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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Object ref);
    }
}
