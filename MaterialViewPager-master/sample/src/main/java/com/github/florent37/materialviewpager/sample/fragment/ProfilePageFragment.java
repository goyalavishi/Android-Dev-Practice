package com.github.florent37.materialviewpager.sample.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.github.florent37.materialviewpager.sample.R;
import com.github.florent37.materialviewpager.sample.bookcrow.LeasedBook;
import com.github.florent37.materialviewpager.sample.bookcrow.Preference;
import com.github.florent37.materialviewpager.sample.bookcrow.RentedBook;
import com.github.florent37.materialviewpager.sample.bookcrow.Settings;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfilePageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfilePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilePageFragment extends Fragment implements AdapterView.OnItemClickListener
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    char gen = 'f';
    ImageView avatar;
    //RelativeLayout rel;
    ListView list;

    ArrayAdapter adp;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfilePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     */
    // TODO: Rename and change types and number of parameters
    public static ProfilePageFragment newInstance() {
        ProfilePageFragment fragment = new ProfilePageFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile_page, container, false);

            list = (ListView) view.findViewById(R.id.listView);
            String s[] = {"My Preferences", "Leased Books", "Rented Books", "Settings", "Logout"};
            adp = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, s);
            //rel=(RelativeLayout)findViewById(R.id.relative);
            avatar = (ImageView) view.findViewById(R.id.imageView);

            if (gen == 'f') {
                // rel.setBackgroundColor(Color.parseColor("#5093ff"));
                avatar.setImageDrawable(getResources().getDrawable(R.drawable.girl));
            } else {
                avatar.setImageDrawable(getResources().getDrawable(R.drawable.boy));
                //rel.setBackgroundColor(Color.parseColor("#5093ff"));
            }
            list.setAdapter(adp);
            list.setOnItemClickListener(this);
            return view;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,[position-1],Toast.LENGTH_SHORT).show();
        if(position==0)
        {
            Intent inent = new Intent(getContext(), Preference.class);
            startActivity(inent);
        }
        else if(position==1)
        {
            Intent inent = new Intent(getActivity(), LeasedBook.class);
            startActivity(inent);
        }
        else if(position==2)
        {
            Intent inent = new Intent(getActivity(), RentedBook.class);
            startActivity(inent);
        }
        else if(position ==3)
        {
            Intent inent = new Intent(getActivity(), Settings.class);
            startActivity(inent);
        }
    }
}
