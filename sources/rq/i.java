package rq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.speech.SpeechRecognizerView;

/* loaded from: classes6.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f74777a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f74778b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f74779c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f74780d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f74781e;

    /* renamed from: f, reason: collision with root package name */
    public final SpeechRecognizerView f74782f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f74783g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f74784h;

    /* renamed from: i, reason: collision with root package name */
    public final View f74785i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f74786j;

    private i(ConstraintLayout constraintLayout, EditText editText, ImageView imageView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, SpeechRecognizerView speechRecognizerView, ImageView imageView2, FrameLayout frameLayout, View view, TextView textView) {
        this.f74777a = constraintLayout;
        this.f74778b = editText;
        this.f74779c = imageView;
        this.f74780d = appCompatImageView;
        this.f74781e = linearLayout;
        this.f74782f = speechRecognizerView;
        this.f74783g = imageView2;
        this.f74784h = frameLayout;
        this.f74785i = view;
        this.f74786j = textView;
    }

    public static i a(View view) {
        View a11;
        int i11 = R$id.comment_input_edit_text;
        EditText editText = (EditText) g4.b.a(view, i11);
        if (editText != null) {
            i11 = R$id.comment_input_search_icon;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.iv_cancel;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ll_top;
                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.sRView;
                        SpeechRecognizerView speechRecognizerView = (SpeechRecognizerView) g4.b.a(view, i11);
                        if (speechRecognizerView != null) {
                            i11 = R$id.search_edit_clear;
                            ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                            if (imageView2 != null) {
                                i11 = R$id.search_fragment_container;
                                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                                if (frameLayout != null && (a11 = g4.b.a(view, (i11 = R$id.top_line))) != null) {
                                    i11 = R$id.tv_search;
                                    TextView textView = (TextView) g4.b.a(view, i11);
                                    if (textView != null) {
                                        return new i((ConstraintLayout) view, editText, imageView, appCompatImageView, linearLayout, speechRecognizerView, imageView2, frameLayout, a11, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_subject, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f74777a;
    }
}
