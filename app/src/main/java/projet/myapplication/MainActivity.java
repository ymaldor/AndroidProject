package projet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        GMapsFragment.OnFragmentInteractionListener,
        ListFragment.OnFragmentInteractionListener,
        FormFragment.OnFragmentInteractionListener {

    private Course course;

    private FormFragment Form;
    private GMapsFragment GMaps;
    private ListFragment List;
    private Button addbtn;
    private Button showbtn;
    private Button GMapsbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Form= FormFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.myFrame, Form).commit();

        //définition des onClicklistener de tous les boutons menus
        addbtn=(Button) findViewById(R.id.Addbtn);
        showbtn=(Button) findViewById(R.id.showbtn);
        GMapsbtn=(Button) findViewById(R.id.GMapsbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              FragmentTransaction fgt;
              FormFragment form=FormFragment.newInstance();
              fgt = getSupportFragmentManager().beginTransaction();
              fgt.addToBackStack("new fragment");
              fgt.replace(R.id.myFrame, form).commit();

          }
      });

        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentTransaction fgt;
                ListFragment List=ListFragment.newInstance();
                fgt = getSupportFragmentManager().beginTransaction();
                fgt.addToBackStack("new fragment");
                fgt.replace(R.id.myFrame, List).commit();
            }
        });







                //fin definition onClickListener boutons menu

    }
    @Override
    public void onFragmentInteraction(Object ref) {
        System.out.println((String) ref);
        Toast.makeText(this, (String) ref, Toast.LENGTH_SHORT).show();
    }
    public void gotomaps(Course course) {

        FragmentTransaction fgt;
        GMapsFragment GMaps=GMapsFragment.newInstance(course);
        fgt = getSupportFragmentManager().beginTransaction();
        fgt.addToBackStack("new fragment");
        fgt.replace(R.id.myFrame, GMaps).commit();}
}
