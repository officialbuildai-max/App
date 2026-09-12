package com.transsion.transfer.wifi.bean;

import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'¨\u0006("}, d2 = {"Lcom/transsion/transfer/wifi/bean/ReportTransferAction;", "", EventConstants.KEY_ACTION, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "REPORT_TRANSFER_ACTION", "REPORT_TRANSFER_ACTION_SHARE_APK_DIALOG", "REPORT_TRANSFER_ACTION_CREATE_PAGE_PV", "REPORT_TRANSFER_ACTION_CREATE_TRIGGER", "REPORT_TRANSFER_ACTION_CREATE_CANCEL", "REPORT_TRANSFER_ACTION_CREATE_SUCCESS", "REPORT_TRANSFER_ACTION_CREATE_FAIL", "REPORT_TRANSFER_ACTION_CONNECT_PAGE_PV", "REPORT_TRANSFER_ACTION_CONNECT_TRIGGER", "REPORT_TRANSFER_ACTION_CONNECT_CANCEL", "REPORT_TRANSFER_ACTION_CONNECT_SUCCESS", "REPORT_TRANSFER_ACTION_CONNECT_FAIL", "REPORT_TRANSFER_ACTION_PERMISSION_REQUEST", "REPORT_TRANSFER_ACTION_PERMISSION_PAGE_PV", "REPORT_TRANSFER_ACTION_SERVER_OPEN", "REPORT_TRANSFER_ACTION_CLIENT_CONNECT_START", "REPORT_TRANSFER_ACTION_CLIENT_CONNECT_SUCCESS", "xREPORT_TRANSFER_ACTION_CLIENT_CONNECT_FAILED", "REPORT_TRANSFER_ACTION_SERVER_CONNECT_SUCCESS", "REPORT_TRANSFER_ACTION_SERVER_DISCONNECT", "REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT", "REPORT_TRANSFER_ACTION_SERVER_SEND_FILE_CMD", "REPORT_TRANSFER_ACTION_CLIENT_RECEIVE_FILE_CMD", "REPORT_TRANSFER_ACTION_CLIENT_FETCH_FILES_START", "REPORT_TRANSFER_ACTION_SERVER_FETCH_FILES_HANDLE", "REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_START", "REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_END", "REPORT_TRANSFER_ACTION_CLIENT_NOTIFY_FINISH", "REPORT_TRANSFER_ACTION_CLIENT_SEND_FILE_NOTIFY", "REPORT_TRANSFER_ACTION_SERVER_RECEIVE_FILE_READY", "REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT_BY_USER", "REPORT_TRANSFER_ACTION_SERVER_DISCONNECT_BY_USER", "Transfer_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ReportTransferAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReportTransferAction[] $VALUES;
    private final String action;
    public static final ReportTransferAction REPORT_TRANSFER_ACTION = new ReportTransferAction("REPORT_TRANSFER_ACTION", 0, EventConstants.KEY_ACTION);
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_SHARE_APK_DIALOG = new ReportTransferAction("REPORT_TRANSFER_ACTION_SHARE_APK_DIALOG", 1, "share_apk_dialog");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CREATE_PAGE_PV = new ReportTransferAction("REPORT_TRANSFER_ACTION_CREATE_PAGE_PV", 2, "create_page");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CREATE_TRIGGER = new ReportTransferAction("REPORT_TRANSFER_ACTION_CREATE_TRIGGER", 3, "create_trigger");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CREATE_CANCEL = new ReportTransferAction("REPORT_TRANSFER_ACTION_CREATE_CANCEL", 4, "create_cancel");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CREATE_SUCCESS = new ReportTransferAction("REPORT_TRANSFER_ACTION_CREATE_SUCCESS", 5, "create_success");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CREATE_FAIL = new ReportTransferAction("REPORT_TRANSFER_ACTION_CREATE_FAIL", 6, "create_fail");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CONNECT_PAGE_PV = new ReportTransferAction("REPORT_TRANSFER_ACTION_CONNECT_PAGE_PV", 7, "connect_page");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CONNECT_TRIGGER = new ReportTransferAction("REPORT_TRANSFER_ACTION_CONNECT_TRIGGER", 8, "connect_trigger");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CONNECT_CANCEL = new ReportTransferAction("REPORT_TRANSFER_ACTION_CONNECT_CANCEL", 9, "connect_cancel");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CONNECT_SUCCESS = new ReportTransferAction("REPORT_TRANSFER_ACTION_CONNECT_SUCCESS", 10, "connect_success");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CONNECT_FAIL = new ReportTransferAction("REPORT_TRANSFER_ACTION_CONNECT_FAIL", 11, "connect_fail");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_PERMISSION_REQUEST = new ReportTransferAction("REPORT_TRANSFER_ACTION_PERMISSION_REQUEST", 12, TmcConstants.MENU_KEY_PERMISSION);
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_PERMISSION_PAGE_PV = new ReportTransferAction("REPORT_TRANSFER_ACTION_PERMISSION_PAGE_PV", 13, "permission_page");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_SERVER_OPEN = new ReportTransferAction("REPORT_TRANSFER_ACTION_SERVER_OPEN", 14, "server_open_success");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_CONNECT_START = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_CONNECT_START", 15, "client_connect_start");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_CONNECT_SUCCESS = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_CONNECT_SUCCESS", 16, "client_connect_success");
    public static final ReportTransferAction xREPORT_TRANSFER_ACTION_CLIENT_CONNECT_FAILED = new ReportTransferAction("xREPORT_TRANSFER_ACTION_CLIENT_CONNECT_FAILED", 17, "client_connect_failed");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_SERVER_CONNECT_SUCCESS = new ReportTransferAction("REPORT_TRANSFER_ACTION_SERVER_CONNECT_SUCCESS", 18, "server_connect_success");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_SERVER_DISCONNECT = new ReportTransferAction("REPORT_TRANSFER_ACTION_SERVER_DISCONNECT", 19, "server_receive_disconnect");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT", 20, "client_receive_disconnect");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_SERVER_SEND_FILE_CMD = new ReportTransferAction("REPORT_TRANSFER_ACTION_SERVER_SEND_FILE_CMD", 21, "server_send_file_cmd");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_RECEIVE_FILE_CMD = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_RECEIVE_FILE_CMD", 22, "client_receive_file_cmd");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_FETCH_FILES_START = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_FETCH_FILES_START", 23, "client_fetch_files_req_start");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_SERVER_FETCH_FILES_HANDLE = new ReportTransferAction("REPORT_TRANSFER_ACTION_SERVER_FETCH_FILES_HANDLE", 24, "server_fetch_files_req_handle");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_START = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_START", 25, "client_download_file_req_start");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_END = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_END", 26, "client_download_file_req_end");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_NOTIFY_FINISH = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_NOTIFY_FINISH", 27, "client_notify_server_file_finish");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_SEND_FILE_NOTIFY = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_SEND_FILE_NOTIFY", 28, "client_send_file_notify");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_SERVER_RECEIVE_FILE_READY = new ReportTransferAction("REPORT_TRANSFER_ACTION_SERVER_RECEIVE_FILE_READY", 29, "server_receive_file_ready");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT_BY_USER = new ReportTransferAction("REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT_BY_USER", 30, "client_disconnect_byuser");
    public static final ReportTransferAction REPORT_TRANSFER_ACTION_SERVER_DISCONNECT_BY_USER = new ReportTransferAction("REPORT_TRANSFER_ACTION_SERVER_DISCONNECT_BY_USER", 31, "server_disconnect_byuser");

    private static final /* synthetic */ ReportTransferAction[] $values() {
        return new ReportTransferAction[]{REPORT_TRANSFER_ACTION, REPORT_TRANSFER_ACTION_SHARE_APK_DIALOG, REPORT_TRANSFER_ACTION_CREATE_PAGE_PV, REPORT_TRANSFER_ACTION_CREATE_TRIGGER, REPORT_TRANSFER_ACTION_CREATE_CANCEL, REPORT_TRANSFER_ACTION_CREATE_SUCCESS, REPORT_TRANSFER_ACTION_CREATE_FAIL, REPORT_TRANSFER_ACTION_CONNECT_PAGE_PV, REPORT_TRANSFER_ACTION_CONNECT_TRIGGER, REPORT_TRANSFER_ACTION_CONNECT_CANCEL, REPORT_TRANSFER_ACTION_CONNECT_SUCCESS, REPORT_TRANSFER_ACTION_CONNECT_FAIL, REPORT_TRANSFER_ACTION_PERMISSION_REQUEST, REPORT_TRANSFER_ACTION_PERMISSION_PAGE_PV, REPORT_TRANSFER_ACTION_SERVER_OPEN, REPORT_TRANSFER_ACTION_CLIENT_CONNECT_START, REPORT_TRANSFER_ACTION_CLIENT_CONNECT_SUCCESS, xREPORT_TRANSFER_ACTION_CLIENT_CONNECT_FAILED, REPORT_TRANSFER_ACTION_SERVER_CONNECT_SUCCESS, REPORT_TRANSFER_ACTION_SERVER_DISCONNECT, REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT, REPORT_TRANSFER_ACTION_SERVER_SEND_FILE_CMD, REPORT_TRANSFER_ACTION_CLIENT_RECEIVE_FILE_CMD, REPORT_TRANSFER_ACTION_CLIENT_FETCH_FILES_START, REPORT_TRANSFER_ACTION_SERVER_FETCH_FILES_HANDLE, REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_START, REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_END, REPORT_TRANSFER_ACTION_CLIENT_NOTIFY_FINISH, REPORT_TRANSFER_ACTION_CLIENT_SEND_FILE_NOTIFY, REPORT_TRANSFER_ACTION_SERVER_RECEIVE_FILE_READY, REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT_BY_USER, REPORT_TRANSFER_ACTION_SERVER_DISCONNECT_BY_USER};
    }

    static {
        ReportTransferAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ReportTransferAction(String str, int i11, String str2) {
        this.action = str2;
    }

    public static EnumEntries<ReportTransferAction> getEntries() {
        return $ENTRIES;
    }

    public static ReportTransferAction valueOf(String str) {
        return (ReportTransferAction) Enum.valueOf(ReportTransferAction.class, str);
    }

    public static ReportTransferAction[] values() {
        return (ReportTransferAction[]) $VALUES.clone();
    }

    public final String getAction() {
        return this.action;
    }
}
