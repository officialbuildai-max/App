package com.bumptech.glide.integration.recyclerview;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class RecyclerToListViewScrollListener extends RecyclerView.r {
    public static final int UNKNOWN_SCROLL_STATE = Integer.MIN_VALUE;
    private final AbsListView.OnScrollListener scrollListener;
    private int lastFirstVisible = -1;
    private int lastVisibleCount = -1;
    private int lastItemCount = -1;

    public RecyclerToListViewScrollListener(@NonNull AbsListView.OnScrollListener onScrollListener) {
        this.scrollListener = onScrollListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        int i12;
        if (i11 != 0) {
            i12 = 1;
            if (i11 != 1) {
                i12 = 2;
                if (i11 != 2) {
                    i12 = Integer.MIN_VALUE;
                }
            }
        } else {
            i12 = 0;
        }
        this.scrollListener.onScrollStateChanged(null, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int abs = Math.abs(findFirstVisibleItemPosition - linearLayoutManager.findLastVisibleItemPosition());
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (findFirstVisibleItemPosition == this.lastFirstVisible && abs == this.lastVisibleCount && itemCount == this.lastItemCount) {
            return;
        }
        this.scrollListener.onScroll(null, findFirstVisibleItemPosition, abs, itemCount);
        this.lastFirstVisible = findFirstVisibleItemPosition;
        this.lastVisibleCount = abs;
        this.lastItemCount = itemCount;
    }
}
