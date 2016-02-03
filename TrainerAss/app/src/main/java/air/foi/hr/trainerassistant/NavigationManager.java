package air.foi.hr.trainerassistant;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import air.foi.hr.trainerassistant.adapter.IzbornikAdapter;
import air.foi.hr.trainerassistant.api.Click;
import air.foi.hr.trainerassistant.api.NavigationItem;


public class NavigationManager {

    public ArrayList<NavigationItem> navigationItems;
    private Activity mHanlderActivity;
    private RecyclerView mRecyclerView;
    private static NavigationManager instance;

    private IzbornikAdapter mNavigationAdapter;

    private NavigationManager(){
        //konstruktor
        navigationItems = new ArrayList<NavigationItem>();
    };
    public static NavigationManager getInstance(){
        //singleton koji provjerava da li je navigation manager iniciliziran
        //ako nije, inicijliziran

        if (instance == null)
            instance = new NavigationManager();
        return instance;
    }

    //slicno kao konstruktor
    public void setDependencies (Activity handlerActivity, RecyclerView recyclerView){
        this.mHanlderActivity = handlerActivity;
        this.mRecyclerView = recyclerView;
    }
    public void addItem(NavigationItem newItem) {
        //dodavanje itema u modularnost i prikazivanje u recyclervieweu
        newItem.setPosition(getNavigationOptions().size() + 1);
        navigationItems.add(newItem);
        mNavigationAdapter = new IzbornikAdapter(mHanlderActivity, getNavigationOptions());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mHanlderActivity));
        mRecyclerView.setAdapter(mNavigationAdapter);
        mNavigationAdapter.notifyDataSetChanged();
    }

    public ArrayList<String> getNavigationOptions(){

        //dohvacanje stringova koji su spremljeni za svaki fragment, kako bi se imalo sto prikazati u listu
        ArrayList<String> navigationOptions = new ArrayList<String>();
        for (NavigationItem item : navigationItems){
            navigationOptions.add(item.getItemName());
        }
        return navigationOptions;

    }

    public void setup(){

        //postavljanje adaptera i liste, te clicka na listu
        //ako se klikne na neki item u listi, poziva se metoda selectitem
        mNavigationAdapter = new IzbornikAdapter(mHanlderActivity, getNavigationOptions());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mHanlderActivity));
        mRecyclerView.setAdapter(mNavigationAdapter);
        mNavigationAdapter.setOnItemClickListener(new Click(){

            @Override
            public void clickListener(int id) {
                selectItem(id);
            }

        });

    }

    private void selectItem(int position){
        //kada se klikne na neki item u recyclerview, poziva se ova metoda
        //zadatak joj je da u contejner stavi kliknuti fragment, a to radi funkcija switchFragment
        switchFragment(position);
        mHanlderActivity.setTitle(getNavigationOptions().get(position));
    }

    private void switchFragment(int position){
        //omogucujes da se desi transakcija sa starog fragmenta na novi fragment koji je kliknut
        Fragment fragment = navigationItems.get(position).getFragment();
        FragmentTransaction transaction = ((FragmentActivity) mHanlderActivity).getSupportFragmentManager().beginTransaction().addToBackStack("air");
        transaction.replace(R.id.izbornik_frame, fragment);
        ((FragmentActivity) mHanlderActivity).getSupportFragmentManager();
        transaction.commit();
    }

    public boolean isEmpty(){
        //provjera dali je lista prazna
        if(getNavigationOptions().size() == 0) return true;
        else return false;
    }

}
