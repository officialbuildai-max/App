package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class e0 extends g1.c implements View.OnClickListener {

    /* renamed from: l, reason: collision with root package name */
    private final SearchView f2063l;

    /* renamed from: m, reason: collision with root package name */
    private final SearchableInfo f2064m;

    /* renamed from: n, reason: collision with root package name */
    private final Context f2065n;

    /* renamed from: o, reason: collision with root package name */
    private final WeakHashMap f2066o;

    /* renamed from: p, reason: collision with root package name */
    private final int f2067p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2068q;

    /* renamed from: r, reason: collision with root package name */
    private int f2069r;

    /* renamed from: s, reason: collision with root package name */
    private ColorStateList f2070s;

    /* renamed from: t, reason: collision with root package name */
    private int f2071t;

    /* renamed from: u, reason: collision with root package name */
    private int f2072u;

    /* renamed from: v, reason: collision with root package name */
    private int f2073v;

    /* renamed from: w, reason: collision with root package name */
    private int f2074w;

    /* renamed from: x, reason: collision with root package name */
    private int f2075x;

    /* renamed from: y, reason: collision with root package name */
    private int f2076y;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f2077a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f2078b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f2079c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f2080d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f2081e;

        public a(View view) {
            this.f2077a = (TextView) view.findViewById(R.id.text1);
            this.f2078b = (TextView) view.findViewById(R.id.text2);
            this.f2079c = (ImageView) view.findViewById(R.id.icon1);
            this.f2080d = (ImageView) view.findViewById(R.id.icon2);
            this.f2081e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public e0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2068q = false;
        this.f2069r = 1;
        this.f2071t = -1;
        this.f2072u = -1;
        this.f2073v = -1;
        this.f2074w = -1;
        this.f2075x = -1;
        this.f2076y = -1;
        this.f2063l = searchView;
        this.f2064m = searchableInfo;
        this.f2067p = searchView.getSuggestionCommitIconResId();
        this.f2065n = context;
        this.f2066o = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2066o.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f2066o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f2070s == null) {
            TypedValue typedValue = new TypedValue();
            this.f2065n.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.f2070s = this.f2065n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2070s, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f2065n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.w("SuggestionsAdapter", e11.toString());
            return null;
        }
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.f2066o.containsKey(flattenToShortString)) {
            Drawable m11 = m(componentName);
            this.f2066o.put(flattenToShortString, m11 != null ? m11.getConstantState() : null);
            return m11;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f2066o.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f2065n.getResources());
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable n11 = n(this.f2064m.getSearchActivity());
        return n11 != null ? n11 : this.f2065n.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f2065n.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(openInputStream, null);
            } finally {
                try {
                    openInputStream.close();
                } catch (IOException e11) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e11);
                }
            }
        } catch (FileNotFoundException e12) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e12.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e12.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2065n.getPackageName() + "/" + parseInt;
            Drawable k11 = k(str2);
            if (k11 != null) {
                return k11;
            }
            Drawable drawable = androidx.core.content.b.getDrawable(this.f2065n, parseInt);
            A(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable k12 = k(str);
            if (k12 != null) {
                return k12;
            }
            Drawable q11 = q(Uri.parse(str));
            A(str, q11);
            return q11;
        }
    }

    private Drawable t(Cursor cursor) {
        int i11 = this.f2074w;
        if (i11 == -1) {
            return null;
        }
        Drawable s11 = s(cursor.getString(i11));
        return s11 != null ? s11 : p();
    }

    private Drawable u(Cursor cursor) {
        int i11 = this.f2075x;
        if (i11 == -1) {
            return null;
        }
        return s(cursor.getString(i11));
    }

    private static String w(Cursor cursor, int i11) {
        if (i11 == -1) {
            return null;
        }
        try {
            return cursor.getString(i11);
        } catch (Exception e11) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e11);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i11) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i11);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // g1.a, g1.b.a
    public void a(Cursor cursor) {
        if (this.f2068q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f2071t = cursor.getColumnIndex("suggest_text_1");
                this.f2072u = cursor.getColumnIndex("suggest_text_2");
                this.f2073v = cursor.getColumnIndex("suggest_text_2_url");
                this.f2074w = cursor.getColumnIndex("suggest_icon_1");
                this.f2075x = cursor.getColumnIndex("suggest_icon_2");
                this.f2076y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e11) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e11);
        }
    }

    @Override // g1.a, g1.b.a
    public CharSequence b(Cursor cursor) {
        String o11;
        String o12;
        if (cursor == null) {
            return null;
        }
        String o13 = o(cursor, "suggest_intent_query");
        if (o13 != null) {
            return o13;
        }
        if (this.f2064m.shouldRewriteQueryFromData() && (o12 = o(cursor, "suggest_intent_data")) != null) {
            return o12;
        }
        if (!this.f2064m.shouldRewriteQueryFromText() || (o11 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o11;
    }

    @Override // g1.b.a
    public Cursor c(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f2063l.getVisibility() == 0 && this.f2063l.getWindowVisibility() == 0) {
            try {
                Cursor v11 = v(this.f2064m, charSequence2, 50);
                if (v11 != null) {
                    v11.getCount();
                    return v11;
                }
            } catch (RuntimeException e11) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e11);
            }
        }
        return null;
    }

    @Override // g1.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i11 = this.f2076y;
        int i12 = i11 != -1 ? cursor.getInt(i11) : 0;
        if (aVar.f2077a != null) {
            z(aVar.f2077a, w(cursor, this.f2071t));
        }
        if (aVar.f2078b != null) {
            String w11 = w(cursor, this.f2073v);
            CharSequence l11 = w11 != null ? l(w11) : w(cursor, this.f2072u);
            if (TextUtils.isEmpty(l11)) {
                TextView textView = aVar.f2077a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f2077a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f2077a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f2077a.setMaxLines(1);
                }
            }
            z(aVar.f2078b, l11);
        }
        ImageView imageView = aVar.f2079c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f2080d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i13 = this.f2069r;
        if (i13 != 2 && (i13 != 1 || (i12 & 1) == 0)) {
            aVar.f2081e.setVisibility(8);
            return;
        }
        aVar.f2081e.setVisibility(0);
        aVar.f2081e.setTag(aVar.f2077a.getText());
        aVar.f2081e.setOnClickListener(this);
    }

    @Override // g1.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i11, view, viewGroup);
        } catch (RuntimeException e11) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e11);
            View g11 = g(this.f2065n, d(), viewGroup);
            if (g11 != null) {
                ((a) g11.getTag()).f2077a.setText(e11.toString());
            }
            return g11;
        }
    }

    @Override // g1.a, android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i11, view, viewGroup);
        } catch (RuntimeException e11) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e11);
            View h11 = h(this.f2065n, d(), viewGroup);
            if (h11 != null) {
                ((a) h11.getTag()).f2077a.setText(e11.toString());
            }
            return h11;
        }
    }

    @Override // g1.c, g1.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h11 = super.h(context, cursor, viewGroup);
        h11.setTag(new a(h11));
        ((ImageView) h11.findViewById(R$id.edit_query)).setImageResource(this.f2067p);
        return h11;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(d());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2063l.v((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f2065n.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i11) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i11 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i11));
        }
        return this.f2065n.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i11) {
        this.f2069r = i11;
    }
}
