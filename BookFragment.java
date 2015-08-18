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
 * Created by manveenkoticha on 8/16/15.
 */
public class BookFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book, container, false);
        //make preview clickable
        ImageView imageView = (ImageView) rootView.findViewById(R.id.book_preview);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/books/details/Barry_Schwartz_The_Paradox_of_Choice?id=g422yyua-P8C&hl=en")));
                //TODO: be able to read articles in-app
            }
        });
        return rootView;
    }
    public BookFragment() {
    }
}
