package on1y.example.org.on1y;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by manveenkoticha on 8/17/15.
 */
public class BusinessFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_business, container, false);
        //make preview clickable
       ImageView imageView = (ImageView) rootView.findViewById(R.id.business_preview);
       imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?t=10&v=ekWMIndt6cA")));
            }
        });
        return rootView;
    }
    public BusinessFragment() {
    }
}