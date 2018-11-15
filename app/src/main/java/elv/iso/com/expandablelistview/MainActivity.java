package elv.iso.com.expandablelistview;


import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListNombres;
    private HashMap<String, Contacto> listaContactos;
    private int lastExpandedPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

        /**
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getBaseContext(),"List Collapsed:" +
                        expandableListNombres.get(groupPosition),Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Toast.makeText(getBaseContext(),
                        expandableListNombres.get(groupPosition) +
                        " ---> " + listaContactos.get(expandableListNombres.get(groupPosition))
                        ,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        */

    }

    private void init() {
        this.expandableListView = findViewById(R.id.expandableListView);
        this.listaContactos = getContactos();
        this.expandableListNombres = new ArrayList<>(listaContactos.keySet());
        this.expandableListAdapter = new CustomExpandableListAdapter(this,
                expandableListNombres, listaContactos);

    }


    private HashMap<String, Contacto> getContactos() {
        HashMap<String, Contacto> listaC = new HashMap<>();

        listaC.put("Juan", new Contacto("111-111-111",
                "juan@correo.com", "Calle 1, 11 - 4D", R.drawable.img_11));
        listaC.put("Sara", new Contacto("222-222-222",
                "sara@correo.com", "Calle 2, 1 - 1A", R.drawable.img_22));
        listaC.put("Raquel", new Contacto("333-333-333",
                "raquel@correo.com", "Calle 3, 3 - 6B", R.drawable.img_33));
        listaC.put("Juan 2", new Contacto("444-444-444",
                "juan@correo.com", "Calle 1, 11 - 4D", R.drawable.img_11));
        listaC.put("Sara 2", new Contacto("555-555-555",
                "sara@correo.com", "Calle 2, 1 - 1A", R.drawable.img_22));
        listaC.put("Raquel 2", new Contacto("666-666-666",
                "raquel@correo.com", "Calle 3, 3 - 6B", R.drawable.img_33));
        listaC.put("Juan 3", new Contacto("777-777-777",
                "juan@correo.com", "Calle 1, 11 - 4D", R.drawable.img_11));
        listaC.put("Sara 3", new Contacto("888-888-888",
                "sara@correo.com", "Calle 2, 1 - 1A", R.drawable.img_22));
        listaC.put("Raquel 3", new Contacto("999-999-999",
                "raquel@correo.com", "Calle 3, 3 - 6B", R.drawable.img_33));


        return listaC;
    }

}
