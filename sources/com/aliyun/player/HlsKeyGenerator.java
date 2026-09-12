package com.aliyun.player;

import com.aliyun.utils.NativeLoader;

/* loaded from: classes2.dex */
public class HlsKeyGenerator {
    private static HlsKeyGenerator instance;
    private OnKeyGenerateListener mOnKeyGenerateListener = null;

    /* loaded from: classes2.dex */
    public interface OnKeyGenerateListener {
        byte[] getHlsKey(String str);

        void onHlsKeyInfoInit(String str, int i11);
    }

    static {
        NativeLoader.loadPlayer();
        instance = null;
    }

    private HlsKeyGenerator() {
    }

    private static byte[] getHlsKey(String str) {
        OnKeyGenerateListener onKeyGenerateListener = getInstance().mOnKeyGenerateListener;
        if (onKeyGenerateListener != null) {
            return onKeyGenerateListener.getHlsKey(str);
        }
        return null;
    }

    public static HlsKeyGenerator getInstance() {
        if (instance == null) {
            synchronized (HlsKeyGenerator.class) {
                try {
                    if (instance == null) {
                        instance = new HlsKeyGenerator();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public static void loadClass() {
    }

    private static void onHlsKeyInfoInit(String str, int i11) {
        OnKeyGenerateListener onKeyGenerateListener = getInstance().mOnKeyGenerateListener;
        if (onKeyGenerateListener != null) {
            onKeyGenerateListener.onHlsKeyInfoInit(str, i11);
        }
    }

    public void setOnKeyGenerateListener(OnKeyGenerateListener onKeyGenerateListener) {
        this.mOnKeyGenerateListener = onKeyGenerateListener;
    }
}
