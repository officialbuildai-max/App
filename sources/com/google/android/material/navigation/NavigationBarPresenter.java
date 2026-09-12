package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.q;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes4.dex */
public class NavigationBarPresenter implements l {

    /* renamed from: a, reason: collision with root package name */
    private androidx.appcompat.view.menu.f f29410a;

    /* renamed from: b, reason: collision with root package name */
    private NavigationBarMenuView f29411b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f29412c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f29413d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f29414a;

        /* renamed from: b, reason: collision with root package name */
        ParcelableSparseArray f29415b;

        /* loaded from: classes4.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f29414a = parcel.readInt();
            this.f29415b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f29414a);
            parcel.writeParcelable(this.f29415b, 0);
        }
    }

    public void a(int i11) {
        this.f29413d = i11;
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean c(androidx.appcompat.view.menu.f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f29411b.k(savedState.f29414a);
            this.f29411b.j(com.google.android.material.badge.c.d(this.f29411b.getContext(), savedState.f29415b));
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f29414a = this.f29411b.getSelectedItemId();
        savedState.f29415b = com.google.android.material.badge.c.e(this.f29411b.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f29413d;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        if (this.f29412c) {
            return;
        }
        if (z10) {
            this.f29411b.buildMenuView();
        } else {
            this.f29411b.updateMenuView();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(androidx.appcompat.view.menu.f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, androidx.appcompat.view.menu.f fVar) {
        this.f29410a = fVar;
        this.f29411b.initialize(fVar);
    }

    public void l(NavigationBarMenuView navigationBarMenuView) {
        this.f29411b = navigationBarMenuView;
    }

    public void m(boolean z10) {
        this.f29412c = z10;
    }
}
