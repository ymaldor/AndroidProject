package projet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        GMapsFragment.OnFragmentInteractionListener,
        ListFragment.OnFragmentInteractionListener,
        FormFragment.OnFragmentInteractionListener {



    private FormFragment Form;
    private GMapsFragment GMaps;
    private ListFragment List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Form= FormFragment.newInstance();
        GMaps= GMapsFragment.newInstance();
        List= ListFragment.newInstance();

        //définition des onClicklistener de tous les boutons menus






        //fin definition onClickListener boutons menu

    }
    @Override
    public void onFragmentInteraction(Object ref) {
        System.out.println((String) ref);
        Toast.makeText(this, (String) ref, Toast.LENGTH_SHORT).show();
    }
}
