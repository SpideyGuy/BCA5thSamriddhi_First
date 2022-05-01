package com.bca.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class FragmentExampleActivity extends AppCompatActivity
implements PopupMenu.OnMenuItemClickListener{

    Button btnContextMenu, btnPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        Fragment fg1 = new Fragment1();
        Fragment fg2 = new Fragment2();

        btnContextMenu = (Button) findViewById(R.id.btn_context_menu);
        btnPopupMenu = (Button) findViewById(R.id.btn_popup_menu);

        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenuPopup();
            }
        });

        registerForContextMenu(btnContextMenu);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft1 = fm.beginTransaction();
        ft1.add(R.id.frag1,fg1);
        ft1.commit();

        FragmentTransaction ft2 = fm.beginTransaction();
        ft2.add(R.id.frag2,fg2);
        ft2.commit();
    }

    public void showMenuPopup(){
        PopupMenu popupMenu = new PopupMenu(this, btnPopupMenu);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.settings_menu);
        popupMenu.show();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share_item:
                Toast.makeText(getApplicationContext(),
                        "Share Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fav_item:
                Toast.makeText(getApplicationContext(),
                        "Favorite Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_item:
                Toast.makeText(getApplicationContext(),
                        "Delete Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share_item:
                Toast.makeText(getApplicationContext(),
                        "Share Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fav_item:
                Toast.makeText(getApplicationContext(),
                        "Favorite Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_item:
                Toast.makeText(getApplicationContext(),
                        "Delete Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.share_item:
                Toast.makeText(getApplicationContext(),
                        "Share Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fav_item:
                Toast.makeText(getApplicationContext(),
                        "Favorite Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_item:
                Toast.makeText(getApplicationContext(),
                        "Delete Selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return true;
        }
    }
}