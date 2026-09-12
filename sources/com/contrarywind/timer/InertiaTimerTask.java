package com.contrarywind.timer;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public final class InertiaTimerTask extends TimerTask {
    private float mCurrentVelocityY = 2.14748365E9f;
    private final float mFirstVelocityY;
    private final WheelView mWheelView;

    public InertiaTimerTask(WheelView wheelView, float f11) {
        this.mWheelView = wheelView;
        this.mFirstVelocityY = f11;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.mCurrentVelocityY == 2.14748365E9f) {
            if (Math.abs(this.mFirstVelocityY) > 2000.0f) {
                this.mCurrentVelocityY = this.mFirstVelocityY <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (Math.abs(this.mCurrentVelocityY) >= 0.0f && Math.abs(this.mCurrentVelocityY) <= 20.0f) {
            this.mWheelView.cancelFuture();
            this.mWheelView.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i11 = (int) (this.mCurrentVelocityY / 100.0f);
        WheelView wheelView = this.mWheelView;
        float f11 = i11;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f11);
        if (!this.mWheelView.isLoop()) {
            float itemHeight = this.mWheelView.getItemHeight();
            float f12 = (-this.mWheelView.getInitPosition()) * itemHeight;
            float itemsCount = ((this.mWheelView.getItemsCount() - 1) - this.mWheelView.getInitPosition()) * itemHeight;
            double d11 = itemHeight * 0.25d;
            if (this.mWheelView.getTotalScrollY() - d11 < f12) {
                f12 = this.mWheelView.getTotalScrollY() + f11;
            } else if (this.mWheelView.getTotalScrollY() + d11 > itemsCount) {
                itemsCount = this.mWheelView.getTotalScrollY() + f11;
            }
            if (this.mWheelView.getTotalScrollY() <= f12) {
                this.mCurrentVelocityY = 40.0f;
                this.mWheelView.setTotalScrollY((int) f12);
            } else if (this.mWheelView.getTotalScrollY() >= itemsCount) {
                this.mWheelView.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        float f13 = this.mCurrentVelocityY;
        if (f13 < 0.0f) {
            this.mCurrentVelocityY = f13 + 20.0f;
        } else {
            this.mCurrentVelocityY = f13 - 20.0f;
        }
        this.mWheelView.getHandler().sendEmptyMessage(1000);
    }
}
