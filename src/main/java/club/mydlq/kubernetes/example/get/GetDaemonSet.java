package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.AppsV1Api;
import io.kubernetes.client.models.V1DaemonSet;
import io.kubernetes.client.models.V1DaemonSetList;

/**
 * - 描述：获取 Daemonset
 * - API版本： apps/v1
 */
public class GetDaemonSet {

    /**
     * 获取全部 Namespace 的 Daemonset 列表
     */
    public static void getAllDaemonSet() throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取全部 Namespace 下的 Daemonset 列表
        V1DaemonSetList daemonSetList = appsV1Api.listDaemonSetForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1DaemonSet item : daemonSetList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 Daemonset 列表
     */
    public static void getNamespaceDaemonSetList(String namespace) throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取某个 Namespace 下的 Daemonset 列表
        V1DaemonSetList daemonSetList = appsV1Api.listNamespacedDaemonSet(namespace, null, null, null, null, null, null, null, null, null);
        for (V1DaemonSet item : daemonSetList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Daemonset
     */
    public static void getNamespaceDaemonSet(String namespace,String daemonsetName) throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取某个 Namespace 下的 Daemonset
        V1DaemonSet daemonSet = appsV1Api.readNamespacedDaemonSet(daemonsetName , namespace, null, null, null);
        System.out.println(daemonSet);
    }

    /**
     * 获取 Daemonset
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 Daemonset
        getAllDaemonSet();
        // 获取某个 Namespace 下的 Daemonset 列表
        getNamespaceDaemonSetList("kube-system");
        // 获取某个 Namespace 的某个 Daemonset
        getNamespaceDaemonSet("kube-system","kube-proxy");
    }

}
