package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.miniapp.bluetooth.BluetoothCode;
import com.cloud.tmc.miniapp.bluetooth.IBluetooth;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.HexUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BluetoothBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();
    public static final String EXTEA_AVALIABLE = "available";
    public static final String EXTEA_DISCOVERING = "discovering";
    public final String OooO00o = "TmcBluetoothBridge";

    /* loaded from: classes3.dex */
    public static final class OooO implements com.cloud.tmc.miniapp.bluetooth.listener.OooO0OO {
        public final /* synthetic */ BridgeCallback OooO0O0;

        public OooO(BridgeCallback bridgeCallback) {
            this.OooO0O0 = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO0OO
        public void OooO00o(String callbackId) {
            Intrinsics.h(callbackId, "callbackId");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBLEConnectionStateChange close -> ");
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO0OO
        public void OooO00o(String address, int i11, int i12) {
            Intrinsics.h(address, "address");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBLEConnectionStateChange notify -> address: " + address + " ; status: " + i11 + " ; newState: " + i12);
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a(PlaceTypes.ADDRESS, address), TuplesKt.a(NotificationCompat.CATEGORY_STATUS, String.valueOf(i11)), TuplesKt.a("newState", String.valueOf(i12))));
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 implements com.cloud.tmc.miniapp.bluetooth.listener.OooO0o {
        public final /* synthetic */ BridgeCallback OooO0O0;

        public OooO0O0(BridgeCallback bridgeCallback) {
            this.OooO0O0 = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO0o
        public void OooO00o(long j11) {
            String str = BluetoothBridge.this.OooO00o;
            BluetoothCode bluetoothCode = BluetoothCode.FAIL;
            TmcLogger.d(str, "getBLEDeviceServices -> code: " + bluetoothCode.getCode() + " ; system_code: " + j11);
            BluetoothBridge.this.OooO00o(this.OooO0O0, bluetoothCode.getCode(), MapsKt.j(TuplesKt.a("system_code", String.valueOf(j11))));
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO0o
        public void OooO00o(List<? extends Map<String, String>> services) {
            Intrinsics.h(services, "services");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "getBLEDeviceServices notify -> services: " + GsonUtils.toJson(services));
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a("services", GsonUtils.toJson(services))));
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function2<Boolean, Boolean, Unit> {
        public final /* synthetic */ BridgeCallback OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0OO(BridgeCallback bridgeCallback) {
            super(2);
            this.OooO0O0 = bridgeCallback;
        }

        public final void OooO00o(boolean z10, boolean z11) {
            TmcLogger.d(BluetoothBridge.this.OooO00o, "getBluetoothAdapterState -> discovering: " + z10 + " ; available: " + z11);
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a(BluetoothBridge.EXTEA_DISCOVERING, String.valueOf(z10)), TuplesKt.a(BluetoothBridge.EXTEA_AVALIABLE, String.valueOf(z11))));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            OooO00o(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o implements com.cloud.tmc.miniapp.bluetooth.listener.OooO0O0 {
        public final /* synthetic */ BridgeCallback OooO0O0;

        public OooO0o(BridgeCallback bridgeCallback) {
            this.OooO0O0 = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO0O0
        public void OooO00o(String callbackId) {
            Intrinsics.h(callbackId, "callbackId");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBLECharacteristicValueChange close -> ");
            this.OooO0O0.close();
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO0O0
        public void OooO00o(String serviceUUID, String characteristicUUID, byte[] value) {
            Intrinsics.h(serviceUUID, "serviceUUID");
            Intrinsics.h(characteristicUUID, "characteristicUUID");
            Intrinsics.h(value, "value");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBLECharacteristicValueChange notify -> serviceUUID: " + serviceUUID + " ; characteristicUUID: " + characteristicUUID + " ; value: " + HexUtil.formatHexString(value));
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a("serviceUUID", serviceUUID), TuplesKt.a("characteristicUUID", characteristicUUID), TuplesKt.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, HexUtil.formatHexString(value))));
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 implements com.cloud.tmc.miniapp.bluetooth.listener.OooOO0O {
        public final /* synthetic */ BridgeCallback OooO0O0;

        public OooOO0(BridgeCallback bridgeCallback) {
            this.OooO0O0 = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooOO0O
        public void OooO00o(String callbackId) {
            Intrinsics.h(callbackId, "callbackId");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBluetoothAdapterStateChange close ->");
            this.OooO0O0.close();
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooOO0O
        public void OooO00o(boolean z10, boolean z11) {
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBluetoothAdapterStateChange notify -> discovering: " + z10 + " ; available: " + z11);
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a(BluetoothBridge.EXTEA_DISCOVERING, String.valueOf(z10)), TuplesKt.a(BluetoothBridge.EXTEA_AVALIABLE, String.valueOf(z11))));
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0O implements com.cloud.tmc.miniapp.bluetooth.listener.OooOOO0 {
        public final /* synthetic */ BridgeCallback OooO0O0;

        public OooOO0O(BridgeCallback bridgeCallback) {
            this.OooO0O0 = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooOOO0
        public void OooO00o(long j11) {
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBluetoothDeviceFound onScanFailed -> code: " + j11);
            BluetoothBridge.this.OooO00o(this.OooO0O0, BluetoothCode.FAIL.getCode(), MapsKt.j(TuplesKt.a("system_code", String.valueOf(j11))));
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooOOO0
        public void OooO00o(String callbackId) {
            Intrinsics.h(callbackId, "callbackId");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBluetoothDeviceFound close -> ");
            this.OooO0O0.close();
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooOOO0
        public void OooO00o(Map<String, String> result) {
            Intrinsics.h(result, "result");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "onBluetoothDeviceFound onScanResult -> result: " + GsonUtils.toJson(result));
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a("result", GsonUtils.toJson(result))));
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOOO implements com.cloud.tmc.miniapp.bluetooth.listener.OooO {
        public final /* synthetic */ BridgeCallback OooO0O0;

        public OooOOO(BridgeCallback bridgeCallback) {
            this.OooO0O0 = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO
        public void OooO00o(String serviceUUID, String characteristicUUID, byte[] value, int i11) {
            Intrinsics.h(serviceUUID, "serviceUUID");
            Intrinsics.h(characteristicUUID, "characteristicUUID");
            Intrinsics.h(value, "value");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "readBLECharacteristicValue notify -> serviceUUID: " + serviceUUID + " ; characteristicUUID: " + characteristicUUID + " ; value: " + HexUtil.formatHexString(value) + " ; status: " + i11);
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a("serviceUUID", serviceUUID), TuplesKt.a("characteristicUUID", characteristicUUID), TuplesKt.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, HexUtil.formatHexString(value)), TuplesKt.a(NotificationCompat.CATEGORY_STATUS, String.valueOf(i11))));
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOOO0 implements com.cloud.tmc.miniapp.bluetooth.listener.OooO00o {
        public final /* synthetic */ BridgeCallback OooO0O0;

        public OooOOO0(BridgeCallback bridgeCallback) {
            this.OooO0O0 = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO00o
        public void OooO00o(long j11) {
            TmcLogger.d(BluetoothBridge.this.OooO00o, "openBluetoothAdapter -> code: " + j11);
            if (j11 == BluetoothCode.OK.getCode()) {
                BluetoothBridge.sendSuccess$default(BluetoothBridge.this, this.OooO0O0, j11, null, 4, null);
            } else {
                BluetoothBridge.sendFail$default(BluetoothBridge.this, this.OooO0O0, j11, null, 4, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOOOO implements com.cloud.tmc.miniapp.bluetooth.listener.OooO {
        public final /* synthetic */ BridgeCallback OooO0O0;

        public OooOOOO(BridgeCallback bridgeCallback) {
            this.OooO0O0 = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooO
        public void OooO00o(String serviceUUID, String characteristicUUID, byte[] value, int i11) {
            Intrinsics.h(serviceUUID, "serviceUUID");
            Intrinsics.h(characteristicUUID, "characteristicUUID");
            Intrinsics.h(value, "value");
            TmcLogger.d(BluetoothBridge.this.OooO00o, "writeBLECharacteristicValue notify -> serviceUUID: " + serviceUUID + " ; characteristicUUID: " + characteristicUUID + " ; value: " + HexUtil.formatHexString(value) + " ; status: " + i11);
            BluetoothBridge.this.OooO0O0(this.OooO0O0, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a("serviceUUID", serviceUUID), TuplesKt.a("characteristicUUID", characteristicUUID), TuplesKt.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, HexUtil.formatHexString(value)), TuplesKt.a(NotificationCompat.CATEGORY_STATUS, String.valueOf(i11))));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendFail$default(BluetoothBridge bluetoothBridge, BridgeCallback bridgeCallback, long j11, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = null;
        }
        bluetoothBridge.OooO00o(bridgeCallback, j11, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendSuccess$default(BluetoothBridge bluetoothBridge, BridgeCallback bridgeCallback, long j11, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = null;
        }
        bluetoothBridge.OooO0O0(bridgeCallback, j11, map);
    }

    public final void OooO00o(BridgeCallback bridgeCallback, long j11, Map<String, String> map) {
        String descript;
        Set<Map.Entry<String, String>> entrySet;
        if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(NativeComponentConstants.KEY_COMPONENT_ERRCODE, Long.valueOf(j11));
            BluetoothCode[] values = BluetoothCode.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    descript = BluetoothCode.FAIL.getDescript();
                    break;
                }
                BluetoothCode bluetoothCode = values[i11];
                if (j11 == bluetoothCode.getCode()) {
                    descript = bluetoothCode.getDescript();
                    break;
                }
                i11++;
            }
            jsonObject.addProperty("errMsg", descript);
            Iterator<Map.Entry<String, String>> it = (map == null || (entrySet = map.entrySet()) == null) ? null : entrySet.iterator();
            while (it != null && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                jsonObject.addProperty(next.getKey(), next.getValue());
            }
            bridgeCallback.sendFailResponse(jsonObject);
        }
    }

    public final void OooO0O0(BridgeCallback bridgeCallback, long j11, Map<String, String> map) {
        Set<Map.Entry<String, String>> entrySet;
        if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("code", Long.valueOf(j11));
            Iterator<Map.Entry<String, String>> it = (map == null || (entrySet = map.entrySet()) == null) ? null : entrySet.iterator();
            while (it != null && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                jsonObject.addProperty(next.getKey(), next.getValue());
            }
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void closeBLEConnection(@BindingParam({"address"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (str == null || str.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
            TmcLogger.d(this.OooO00o, "closeBLEConnection -> code: " + bluetoothCode.getCode());
            return;
        }
        long closeBLEConnection = ((IBluetooth) TmcProxy.get(IBluetooth.class)).closeBLEConnection(str);
        TmcLogger.d(this.OooO00o, "closeBLEConnection -> code: " + closeBLEConnection);
        if (closeBLEConnection == BluetoothCode.OK.getCode()) {
            sendSuccess$default(this, bridgeCallback, closeBLEConnection, null, 4, null);
        } else {
            sendFail$default(this, bridgeCallback, closeBLEConnection, null, 4, null);
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void closeBluetoothAdapter(@BindingCallback BridgeCallback bridgeCallback) {
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).closeBluetoothAdapter();
        String str = this.OooO00o;
        BluetoothCode bluetoothCode = BluetoothCode.OK;
        TmcLogger.d(str, "closeBluetoothAdapter -> code: " + bluetoothCode.getCode());
        sendSuccess$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void createBLEConnection(@BindingParam({"address"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        TmcLogger.d(this.OooO00o, "createBLEConnection -> address: " + str);
        if (str == null || str.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
            TmcLogger.d(this.OooO00o, "createBLEConnection -> code: " + bluetoothCode.getCode());
            return;
        }
        long createBLEConnection = ((IBluetooth) TmcProxy.get(IBluetooth.class)).createBLEConnection(str);
        TmcLogger.d(this.OooO00o, "createBLEConnection -> code: " + createBLEConnection);
        if (createBLEConnection == BluetoothCode.OK.getCode()) {
            sendSuccess$default(this, bridgeCallback, createBLEConnection, null, 4, null);
        } else {
            sendFail$default(this, bridgeCallback, createBLEConnection, null, 4, null);
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getBLEDeviceCharacteristics(@BindingParam({"serviceUUID"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (str == null || str.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
            TmcLogger.d(this.OooO00o, "getBLEDeviceCharacteristics -> code: " + bluetoothCode.getCode());
            return;
        }
        List<Map<String, String>> bLEDeviceCharacteristicsMap = ((IBluetooth) TmcProxy.get(IBluetooth.class)).getBLEDeviceCharacteristicsMap(str);
        TmcLogger.d(this.OooO00o, "getBLEDeviceCharacteristics -> characteristics: " + GsonUtils.toJson(bLEDeviceCharacteristicsMap));
        OooO0O0(bridgeCallback, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a("characteristics", GsonUtils.toJson(bLEDeviceCharacteristicsMap))));
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getBLEDeviceServices(@BindingCallback BridgeCallback bridgeCallback) {
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).getBLEDeviceServices(new OooO0O0(bridgeCallback));
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getBluetoothAdapterState(@BindingCallback BridgeCallback bridgeCallback) {
        long bluetoothAdapterState = ((IBluetooth) TmcProxy.get(IBluetooth.class)).getBluetoothAdapterState(new OooO0OO(bridgeCallback));
        if (bluetoothAdapterState != BluetoothCode.OK.getCode()) {
            TmcLogger.d(this.OooO00o, "getBluetoothAdapterState fail -> code: " + bluetoothAdapterState);
            sendFail$default(this, bridgeCallback, bluetoothAdapterState, null, 4, null);
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getConnectedBluetoothDevices(@BindingCallback BridgeCallback bridgeCallback) {
        List<Map<String, String>> connectedBluetoothDevicesMap = ((IBluetooth) TmcProxy.get(IBluetooth.class)).getConnectedBluetoothDevicesMap();
        TmcLogger.d(this.OooO00o, "getConnectedBluetoothDevices -> devices: " + GsonUtils.toJson(connectedBluetoothDevicesMap));
        OooO0O0(bridgeCallback, BluetoothCode.OK.getCode(), MapsKt.j(TuplesKt.a("devices", GsonUtils.toJson(connectedBluetoothDevicesMap))));
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void notifyBLECharacteristicValueChange(@BindingParam({"serviceUUID"}) String str, @BindingParam({"characteristicUUID"}) String str2, @BindingParam({"enable"}) Boolean bool, @BindingCallback BridgeCallback bridgeCallback) {
        if (str == null || str2 == null || bool == null || str.length() <= 0 || str2.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
            TmcLogger.d(this.OooO00o, "notifyBLECharacteristicValueChange -> code: " + bluetoothCode.getCode());
            return;
        }
        long notifyBLECharacteristicValueChange = ((IBluetooth) TmcProxy.get(IBluetooth.class)).notifyBLECharacteristicValueChange(str, str2, bool.booleanValue());
        TmcLogger.d(this.OooO00o, "notifyBLECharacteristicValueChange -> code: " + notifyBLECharacteristicValueChange);
        if (notifyBLECharacteristicValueChange == BluetoothCode.OK.getCode()) {
            sendSuccess$default(this, bridgeCallback, notifyBLECharacteristicValueChange, null, 4, null);
        } else {
            sendFail$default(this, bridgeCallback, notifyBLECharacteristicValueChange, null, 4, null);
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void offBLECharacteristicValueChange(@BindingCallback BridgeCallback bridgeCallback) {
        String callbackId;
        if (bridgeCallback == null || (callbackId = bridgeCallback.getCallbackId()) == null) {
            return;
        }
        TmcLogger.d(this.OooO00o, "offBLECharacteristicValueChange close -> ");
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).offBLECharacteristicValueChange(callbackId);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void offBLEConnectionStateChange(@BindingCallback BridgeCallback bridgeCallback) {
        String callbackId;
        if (bridgeCallback == null || (callbackId = bridgeCallback.getCallbackId()) == null) {
            return;
        }
        TmcLogger.d(this.OooO00o, "offBLEConnectionStateChange -> ");
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).offBLEConnectionStateChange(callbackId);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void offBluetoothAdapterStateChange(@BindingCallback BridgeCallback bridgeCallback) {
        String callbackId;
        if (bridgeCallback == null || (callbackId = bridgeCallback.getCallbackId()) == null) {
            return;
        }
        TmcLogger.d(this.OooO00o, "offBluetoothAdapterStateChange ->");
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).offBluetoothAdapterStateChange(callbackId);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void offBluetoothDeviceFound(@BindingCallback BridgeCallback bridgeCallback) {
        String callbackId;
        if (bridgeCallback == null || (callbackId = bridgeCallback.getCallbackId()) == null) {
            return;
        }
        TmcLogger.d(this.OooO00o, "offBluetoothDeviceFound -> ");
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).offBluetoothDeviceFound(callbackId);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void onBLECharacteristicValueChange(@BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        String callbackId;
        if (bridgeCallback == null || (callbackId = bridgeCallback.getCallbackId()) == null) {
            return;
        }
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).onBLECharacteristicValueChange(callbackId, new OooO0o(bridgeCallback));
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void onBLEConnectionStateChange(@BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        String callbackId;
        if (bridgeCallback == null || (callbackId = bridgeCallback.getCallbackId()) == null) {
            return;
        }
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).onBLEConnectionStateChange(callbackId, new OooO(bridgeCallback));
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void onBluetoothAdapterStateChange(@BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        String callbackId;
        if (bridgeCallback == null || (callbackId = bridgeCallback.getCallbackId()) == null) {
            return;
        }
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).onBluetoothAdapterStateChange(callbackId, new OooOO0(bridgeCallback));
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void onBluetoothDeviceFound(@BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        String callbackId;
        if (bridgeCallback == null || (callbackId = bridgeCallback.getCallbackId()) == null) {
            return;
        }
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).onBluetoothDeviceFound(callbackId, new OooOO0O(bridgeCallback));
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void openBluetoothAdapter(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        AppContext appContext;
        if (((app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext()) != null) {
            IBluetooth iBluetooth = (IBluetooth) TmcProxy.get(IBluetooth.class);
            AppContext appContext2 = app.getAppContext();
            Intrinsics.e(appContext2);
            Context context = appContext2.getContext();
            Intrinsics.g(context, "app.appContext!!.context");
            iBluetooth.openBluetoothAdapter(context, new OooOOO0(bridgeCallback));
            return;
        }
        String str = this.OooO00o;
        BluetoothCode bluetoothCode = BluetoothCode.SYSTEM_ERROR;
        TmcLogger.d(str, "openBluetoothAdapter fail -> code: " + bluetoothCode.getCode());
        sendFail$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void readBLECharacteristicValue(@BindingParam({"serviceUUID"}) String str, @BindingParam({"characteristicUUID"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        if (str == null || str2 == null || str.length() <= 0 || str2.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
            TmcLogger.d(this.OooO00o, "readBLECharacteristicValue -> code: " + bluetoothCode.getCode());
            return;
        }
        long readBLECharacteristicValue = ((IBluetooth) TmcProxy.get(IBluetooth.class)).readBLECharacteristicValue(str, str2, new OooOOO(bridgeCallback));
        TmcLogger.d(this.OooO00o, "readBLECharacteristicValue -> code: " + readBLECharacteristicValue);
        if (readBLECharacteristicValue != BluetoothCode.OK.getCode()) {
            sendFail$default(this, bridgeCallback, readBLECharacteristicValue, null, 4, null);
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void startBluetoothDevicesDiscovery(@BindingParam({"serviceUUIDS"}) String str, @BindingParam({"powerLevel"}) Integer num, @BindingCallback BridgeCallback bridgeCallback) {
        List<String> arrayList;
        try {
            Object fromJson = GsonUtils.fromJson(str, new TypeToken<List<? extends String>>() { // from class: com.cloud.tmc.miniapp.bridge.BluetoothBridge$startBluetoothDevicesDiscovery$1
            }.getType());
            Intrinsics.g(fromJson, "fromJson(serviceUUIDS, o…ist<String?>?>() {}.type)");
            arrayList = (List) fromJson;
        } catch (Exception unused) {
            arrayList = new ArrayList<>();
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
            TmcLogger.d(this.OooO00o, "startBluetoothDevicesDiscovery -> code: " + bluetoothCode.getCode());
        }
        long startBluetoothDevicesDiscovery = ((IBluetooth) TmcProxy.get(IBluetooth.class)).startBluetoothDevicesDiscovery(arrayList, num != null ? num.intValue() : 0);
        TmcLogger.d(this.OooO00o, "startBluetoothDevicesDiscovery -> code: " + startBluetoothDevicesDiscovery);
        if (startBluetoothDevicesDiscovery == BluetoothCode.OK.getCode()) {
            sendSuccess$default(this, bridgeCallback, startBluetoothDevicesDiscovery, null, 4, null);
        } else {
            sendFail$default(this, bridgeCallback, startBluetoothDevicesDiscovery, null, 4, null);
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void stopBluetoothDevicesDiscovery(@BindingCallback BridgeCallback bridgeCallback) {
        ((IBluetooth) TmcProxy.get(IBluetooth.class)).stopBluetoothDevicesDiscovery();
        String str = this.OooO00o;
        BluetoothCode bluetoothCode = BluetoothCode.OK;
        TmcLogger.d(str, "stopBluetoothDevicesDiscovery -> code: " + bluetoothCode.getCode());
        sendSuccess$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void writeBLECharacteristicValue(@BindingParam({"serviceUUID"}) String str, @BindingParam({"characteristicUUID"}) String str2, @BindingParam({"value"}) String str3, @BindingCallback BridgeCallback bridgeCallback) {
        if (str == null || str2 == null || str3 == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            BluetoothCode bluetoothCode = BluetoothCode.INVALID_DATA;
            sendFail$default(this, bridgeCallback, bluetoothCode.getCode(), null, 4, null);
            TmcLogger.d(this.OooO00o, "writeBLECharacteristicValue -> code: " + bluetoothCode.getCode());
            return;
        }
        IBluetooth iBluetooth = (IBluetooth) TmcProxy.get(IBluetooth.class);
        byte[] hexStringToBytes = HexUtil.hexStringToBytes(str3);
        Intrinsics.g(hexStringToBytes, "hexStringToBytes(value)");
        long writeBLECharacteristicValue = iBluetooth.writeBLECharacteristicValue(str, str2, hexStringToBytes, new OooOOOO(bridgeCallback));
        TmcLogger.d(this.OooO00o, "writeBLECharacteristicValue -> code: " + writeBLECharacteristicValue);
        if (writeBLECharacteristicValue != BluetoothCode.OK.getCode()) {
            sendFail$default(this, bridgeCallback, writeBLECharacteristicValue, null, 4, null);
        }
    }
}
