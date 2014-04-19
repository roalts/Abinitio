package com.roalts.abinitio;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Roalts.
 */
public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public Context context;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        context = getApplicationContext();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }


    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.about_us);
                break;
            case 2:
                mTitle = getString(R.string.title_section1);
                break;
            case 3:
                mTitle = getString(R.string.title_section2);
                break;
            case 4:
                mTitle = getString(R.string.title_section3);
                break;
            case 5:
                mTitle = getString(R.string.title_sec5);
                break;
            case 6:
                mTitle = getString(R.string.title_sec4);
                break;
            case 7:
                mTitle = getString(R.string.contact_us);
                break;
            case 8:
                mTitle = getString(R.string.like_us);
                break;

        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    /**
     * A placeholder fragment containing a simple view.
     */

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView eventDescription = (TextView)rootView.findViewById(R.id.event_description);


            String descriptions;

            ImageView img = (ImageView) rootView.findViewById(R.id.event_icon);
            if(getArguments().getInt(ARG_SECTION_NUMBER)==1) {
                Toast.makeText(getActivity(), "About Us", Toast.LENGTH_SHORT).show();
                descriptions = getResources().getString(R.string.aboutus);

                try {
                    eventDescription.setText(descriptions);
                } catch (Exception e) {
                    eventDescription.setText("No Description");
                }

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                img.setImageResource(R.drawable.crypto_hunt);

                Toast.makeText(getActivity(), "Get Crackin'", Toast.LENGTH_SHORT).show();
                 descriptions = getResources().getString(R.string.crypto);

                try {
                    eventDescription.setText(descriptions);
                } catch (Exception e) {
                    eventDescription.setText("No Description");
                }
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {

                Toast.makeText(getActivity(), "Battle With Style", Toast.LENGTH_SHORT).show();
                img.setImageResource(R.drawable.chess_sapiens);
                descriptions = getResources().getString(R.string.chess_sapiens);

                try {
                    eventDescription.setText(descriptions);
                } catch (Exception e) {
                   eventDescription.setText("No Description");
                }
            }


            if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
                img.setImageResource(R.drawable.elecc);

                Toast.makeText(getActivity(), "Phase the Difference", Toast.LENGTH_SHORT).show();

                descriptions = getResources().getString(R.string.electrified);

                try {
                    eventDescription.setText(descriptions);
                } catch (Exception e) {
                    eventDescription.setText("No Description");
                }
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 5) {
               img.setImageResource(R.drawable.amigos);

                Toast.makeText(getActivity(), "Know Your Buddy", Toast.LENGTH_SHORT).show();

                descriptions = getResources().getString(R.string.amigos);

                try {
                    eventDescription.setText(descriptions);
                } catch (Exception e) {
                    eventDescription.setText("No Description");
                }
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 6) {
                img.setImageResource(R.drawable.bidthebiz);

                Toast.makeText(getActivity(), "Bid. Plan. Execute.", Toast.LENGTH_SHORT).show();

                descriptions = getResources().getString(R.string.bid_biz);

                try {
                    eventDescription.setText(descriptions);
                } catch (Exception e) {
                    eventDescription.setText("No Description");
                }
            }

            if(getArguments().getInt(ARG_SECTION_NUMBER)==7) {
                String url = "https://abinitio.dcetech.com";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 8) {
                String url = "https://www.facebook.com/abinitioieeedtu";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }

            return rootView;
        }


        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

    }
}




