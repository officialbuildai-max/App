package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ListFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f9476a = new Handler();

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f9477b = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f9480e;
            listView.focusableViewAvailable(listView);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f9478c = new a();

    /* renamed from: d, reason: collision with root package name */
    ListAdapter f9479d;

    /* renamed from: e, reason: collision with root package name */
    ListView f9480e;

    /* renamed from: f, reason: collision with root package name */
    View f9481f;

    /* renamed from: g, reason: collision with root package name */
    TextView f9482g;

    /* renamed from: h, reason: collision with root package name */
    View f9483h;

    /* renamed from: i, reason: collision with root package name */
    View f9484i;

    /* renamed from: j, reason: collision with root package name */
    CharSequence f9485j;

    /* renamed from: k, reason: collision with root package name */
    boolean f9486k;

    /* loaded from: classes.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
            ListFragment.this.W((ListView) adapterView, view, i11, j11);
        }
    }

    private void V() {
        if (this.f9480e != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.f9480e = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(16711681);
            this.f9482g = textView;
            if (textView == null) {
                this.f9481f = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.f9483h = view.findViewById(16711682);
            this.f9484i = view.findViewById(16711683);
            View findViewById = view.findViewById(R.id.list);
            if (!(findViewById instanceof ListView)) {
                if (findViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) findViewById;
            this.f9480e = listView;
            View view2 = this.f9481f;
            if (view2 != null) {
                listView.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.f9485j;
                if (charSequence != null) {
                    this.f9482g.setText(charSequence);
                    this.f9480e.setEmptyView(this.f9482g);
                }
            }
        }
        this.f9486k = true;
        this.f9480e.setOnItemClickListener(this.f9478c);
        ListAdapter listAdapter = this.f9479d;
        if (listAdapter != null) {
            this.f9479d = null;
            X(listAdapter);
        } else if (this.f9483h != null) {
            Y(false, false);
        }
        this.f9476a.post(this.f9477b);
    }

    private void Y(boolean z10, boolean z11) {
        V();
        View view = this.f9483h;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f9486k == z10) {
            return;
        }
        this.f9486k = z10;
        if (z10) {
            if (z11) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                this.f9484i.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.f9484i.clearAnimation();
            }
            this.f9483h.setVisibility(8);
            this.f9484i.setVisibility(0);
            return;
        }
        if (z11) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            this.f9484i.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.f9484i.clearAnimation();
        }
        this.f9483h.setVisibility(0);
        this.f9484i.setVisibility(8);
    }

    public void W(ListView listView, View view, int i11, long j11) {
    }

    public void X(ListAdapter listAdapter) {
        boolean z10 = this.f9479d != null;
        this.f9479d = listAdapter;
        ListView listView = this.f9480e;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.f9486k || z10) {
                return;
            }
            Y(true, requireView().getWindowToken() != null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f9476a.removeCallbacks(this.f9477b);
        this.f9480e = null;
        this.f9486k = false;
        this.f9484i = null;
        this.f9483h = null;
        this.f9481f = null;
        this.f9482g = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        V();
    }
}
