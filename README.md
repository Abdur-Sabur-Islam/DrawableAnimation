# DrawableAnimation
Add in Drawable XML Resource
```xml
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"
android:oneshot="true">
    <item android:drawable="@drawable/imageone" android:duration="200" />
    <item android:drawable="@drawable/imageTwo" android:duration="200" />
    <item android:drawable="@drawable/imageThree" android:duration="200" />
</animation-list> 
```
the android:oneshot attribute of the list to true, it will cycle just once then stop and hold on the last frame. If it is set false then the animation will loop.
 
 
 then aply in Main Activity
 
 public class MainActivity extends AppCompatActivity {

   static AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, new PlaceHolderFragment()).commit();
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            rocketAnimation.start();
            return true;
        }
        return super.onTouchEvent(event);
    }
    public static class PlaceHolderFragment extends Fragment {


        public PlaceHolderFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view =  inflater.inflate(R.layout.fragment_place_holder, container, false);

            ImageView progress = (ImageView)view.findViewById(R.id.image);

            progress.setBackgroundResource(R.drawable.rocket_trust);
            rocketAnimation = (AnimationDrawable) progress.getBackground();
            return view;
        }
    }
}

