package com.amolina.first;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {


    private SwipeRefreshLayout swipeLayout;
    private WebView mycontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=new Intent(this,MainBAB.class);
        startActivity(intent);

//casting a la vista a la que se aplica el menu contextual
        mycontext = findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);
        mycontext.getSettings().setBuiltInZoomControls(true);
        mycontext.loadUrl("https://thispersondoesnotexist.com");


        swipeLayout = findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            return true;
        }
        if (id == R.id.like) {
            Toast toast = Toast.makeText(this, "Added to favourites", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        if (id == R.id.exit) {
            System.exit(0);
        }
        if (id == R.id.alert) {
            showAlertDialogButtonClicked(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast = Toast.makeText(Main.this, "Hi there, I dont exist :)", Toast.LENGTH_LONG);
            toast.show();
            mycontext.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
//                Toast toast = Toast.makeText(this,"Item copied",Toast.LENGTH_LONG);
//                toast.show();

                final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);

                Snackbar snackbar = Snackbar
                        .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored", Snackbar.LENGTH_LONG);
                                snackbar1.show();
                            }
                        });
                snackbar.show();

                return true;

            case R.id.item2:
                Toast toasto = Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG);
                toasto.show();
                return true;

            default:
                //return super.onContextItemSelected(item);
                return false;
        }
    }

    public void showAlertDialogButtonClicked(Main view) {
        // setup the alert builder
        MaterialAlertDialogBuilder builder = new
                MaterialAlertDialogBuilder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo
        //por un XML a medida


        builder.setTitle("Is that you?");
        builder.setMessage("Log in please");

        builder.setPositiveButton("Accept", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("Cancel", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        identidadFalsa();

                    }
                });

        builder.setNeutralButton("Exit", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        finishAfterTransition();
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public  void identidadFalsa(){
        Toast toasto = Toast.makeText(this, "Vuelve a iniciar sesion", Toast.LENGTH_LONG);
        toasto.show();
        Intent intent = new Intent(this, Splashu.class);
        startActivity(intent);
    }
}
