package com.cloud.tmc.miniapp.utils.toast.config;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public interface IToast {

    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static ImageView findIconView(IToast iToast, View view) {
            View findViewById = view != null ? view.findViewById(R.id.icon) : null;
            if (findViewById instanceof ImageView) {
                return (ImageView) findViewById;
            }
            return null;
        }

        public static TextView findMessageView(IToast iToast, View view) {
            Intrinsics.h(view, "view");
            if (!(view instanceof TextView)) {
                View findViewById = view.findViewById(R.id.message);
                if (findViewById instanceof TextView) {
                    return (TextView) findViewById;
                }
                throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
            }
            if (view.getId() == -1) {
                view.setId(R.id.message);
            } else if (view.getId() != 16908299) {
                throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message");
            }
            return (TextView) view;
        }
    }

    void cancel();

    ImageView findIconView(View view);

    TextView findMessageView(View view);

    int getDuration();

    int getGravity();

    float getHorizontalMargin();

    float getVerticalMargin();

    View getView();

    int getXOffset();

    int getYOffset();

    void setDuration(int i11);

    void setGravity(int i11, int i12, int i13);

    void setMargin(float f11, float f12);

    void setText(int i11);

    void setText(CharSequence charSequence);

    void setView(View view);

    void show();
}
