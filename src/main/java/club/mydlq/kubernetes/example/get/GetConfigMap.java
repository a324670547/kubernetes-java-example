package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1ConfigMap;
import io.kubernetes.client.models.V1ConfigMapList;

/**
 * - 描述：获取 ConfigMap
 * - API版本： v1
 */
public class GetConfigMap {

    /**
     * 获取全部 Namespace 的 ConfigMap 列表
     */
    public static void getAllConfigMap() throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Namespace 的 ConfigMap 列表
        V1ConfigMapList configMapList = api.listConfigMapForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1ConfigMap item : configMapList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 ConfigMap 列表
     */
    public static void getNamespaceConfigMapList(String namespace) throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 下的 ConfigMap 列表
        V1ConfigMapList configMapList = api.listNamespacedConfigMap(namespace, null, null,null, null, null, null, null, null, null);
        for (V1ConfigMap item : configMapList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 ConfigMap
     */
    public static void getNamespaceConfigMap(String namespace, String configMapName) throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 下的 ConfigMa
        V1ConfigMap configMap = api.readNamespacedConfigMap(configMapName, namespace, null, null, null);
        System.out.println(configMap);
    }

    /**
     * 获取 ConfigMap
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取全部 Namespace 的 ConfigMap 列表
        getAllConfigMap();
        // 获取某个 Namespace 的 ConfigMap 列表
        getNamespaceConfigMapList("kube-system");
        // 获取某个 Namespace 的某个 ConfigMap
        getNamespaceConfigMap("kube-system", "coredns");
    }

}
