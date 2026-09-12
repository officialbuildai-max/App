package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes3.dex */
public class PrepareException extends Exception implements Parcelable {
    public static final Parcelable.Creator<PrepareException> CREATOR = new OooO00o();
    public static final String ERROR_DOWNLOAD_PACKAGE_URL_EMPTY = "11";
    public static final String ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION = "14";
    public static final String ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION = "15";
    public static final String ERROR_LOCAL_DATA_FILE_SCAN = "12";
    public static final String ERROR_MANIFEST_INFO = "8";
    public static final String ERROR_MINI_APPID = "10";
    public static final String ERROR_MINI_APP_CLOSE = "9";
    public static final String ERROR_NO_APPINFO = "1";
    public static final String ERROR_NO_URL = "6";
    public static final String ERROR_RPC_EXCEPTION = "2";
    public static final String ERROR_SIGN_ERROR = "7";
    public static final String ERROR_TIMEOUT = "3";
    public static final String ERROR_UNKNOWN = "0";
    public static final String ERROR_UNSTABLE_EXCEPTION = "4";
    public static final String ERROR_UNZIP_EXCEPTION = "5";
    public static final String ERROR_WARMUP_DOWNLOAD_EXCEPTION = "13";
    private String code;
    private boolean needShowFail;

    /* loaded from: classes3.dex */
    public class OooO00o implements Parcelable.Creator<PrepareException> {
        @Override // android.os.Parcelable.Creator
        public PrepareException createFromParcel(Parcel parcel) {
            return new PrepareException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PrepareException[] newArray(int i11) {
            return new PrepareException[i11];
        }
    }

    public PrepareException(Parcel parcel) {
        this.code = parcel.readString();
    }

    public PrepareException(String str) {
        this("0", str, null);
    }

    public PrepareException(String str, String str2) {
        this(str, str2, null);
    }

    public PrepareException(String str, String str2, Throwable th2) {
        super(str2, th2);
        this.code = str;
        str.getClass();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 50:
                if (str.equals("2")) {
                    c11 = 0;
                    break;
                }
                break;
            case AD_REWARD_USER_VALUE:
                if (str.equals("3")) {
                    c11 = 1;
                    break;
                }
                break;
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                if (str.equals("4")) {
                    c11 = 2;
                    break;
                }
                break;
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                if (str.equals("5")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.needShowFail = true;
                return;
            default:
                return;
        }
    }

    public static String codeToDes(String str) {
        if (str == null) {
            return "";
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                if (str.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                if (str.equals("1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 2;
                    break;
                }
                break;
            case AD_REWARD_USER_VALUE:
                if (str.equals("3")) {
                    c11 = 3;
                    break;
                }
                break;
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                if (str.equals("4")) {
                    c11 = 4;
                    break;
                }
                break;
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                if (str.equals("5")) {
                    c11 = 5;
                    break;
                }
                break;
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                if (str.equals(ERROR_NO_URL)) {
                    c11 = 6;
                    break;
                }
                break;
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                if (str.equals("7")) {
                    c11 = 7;
                    break;
                }
                break;
            case AD_VISIBILITY_VALUE:
                if (str.equals(ERROR_MANIFEST_INFO)) {
                    c11 = '\b';
                    break;
                }
                break;
            case 57:
                if (str.equals(ERROR_MINI_APP_CLOSE)) {
                    c11 = '\t';
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c11 = '\n';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return "未知错误";
            case 1:
                return "未找到AppInfo";
            case 2:
                return "ERROR_RPC_EXCEPTION";
            case 3:
                return "无网并且必须同步拉取 APPINFO";
            case 4:
                return "包下载异常，或者包文件不存在";
            case 5:
                return "解压异常";
            case 6:
                return "ERROR_NO_URL";
            case 7:
                return "签名校验异常";
            case '\b':
                return "清单文件读取异常";
            case '\t':
                return "小程序已停用";
            case '\n':
                return "错误的小程序ID";
            default:
                return "错误码:" + str;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.code;
    }

    public boolean isNeedShowFail() {
        return this.needShowFail;
    }

    public void setNeedShowFail(boolean z10) {
        this.needShowFail = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.code);
    }
}
