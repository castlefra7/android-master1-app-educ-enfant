package itu.master1.projetandroid.menu.view.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.Locale;

import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.model.Content;

public class CourseDetailFragment extends Fragment {

    private long contentId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_course_detail, parent, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null) {
            TextView title = (TextView) view.findViewById(R.id.txtTitle);
            TextView desc = (TextView)view.findViewById(R.id.txtDescription);
            Content content =  Content.contents[(int)contentId];

            title.setText(content.getTitle().toUpperCase(Locale.ROOT));
            desc.setText(content.getDescription());
        }
    }


    public void setContent(long id) {
        this.contentId = id;
    }
}
