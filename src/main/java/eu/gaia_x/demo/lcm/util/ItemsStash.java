package eu.gaia_x.demo.lcm.util;

import eu.gaia_x.demo.common.ErrorDto;
import eu.gaia_x.demo.dashboard.model.ActivateRq;
import eu.gaia_x.demo.dashboard.model.DatasetItem;
import eu.gaia_x.demo.dashboard.model.ServiceItem;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ItemsStash {

    private final List<String> statuses;

    @Getter private final List<DatasetItem> pprDatasets;
    @Getter private final List<ServiceItem> pprServices;

    @Getter private final List<DatasetItem> pcrDatasets;
    @Getter private final List<ServiceItem> pcrServices;

    @Getter private final List<ServiceItem> sp;

    public ItemsStash() {
        this.statuses = Arrays.asList(
                "deploying",
                "deployed",
                "undeploying",
                "undeployed",
                "null"
        );
        pprDatasets = createDatasets(true, 100);
        pcrDatasets = createDatasets(false, 200);

        pprServices = createServices(true, 300);
        pcrServices = createServices(false, 400);

        sp = createServices(false, 500);
    }

    private List<DatasetItem> createDatasets(boolean isPpr, int offset) {
        List<DatasetItem> items = new ArrayList<>();
        for (int x = 0; x < statuses.size(); x++) {
            boolean activated = !statuses.get(x).equalsIgnoreCase("null");
            String status = activated ? statuses.get(x) : null;
            int id = x + offset;
            items.add(new DatasetItem(
                    String.valueOf(id),
                    "Name #" + id,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Horseshoe_Bend_TC_27-09-2012_15-34-14.jpg/1599px-Horseshoe_Bend_TC_27-09-2012_15-34-14.jpg",
                    "http://url.com",
                    "https://cdn.logo.com/hotlink-ok/logo-social.png",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                    activated,
                    isPpr,
                    status
            ));
        }
        if (isPpr) {
            int id = items.size() + offset + 10;
            items.add(new DatasetItem(
                    String.valueOf(id),
                    "Name #" + id,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Horseshoe_Bend_TC_27-09-2012_15-34-14.jpg/1599px-Horseshoe_Bend_TC_27-09-2012_15-34-14.jpg",
                    "http://url.com",
                    "https://cdn.logo.com/hotlink-ok/logo-social.png",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                    false,
                    false,
                    null
            ));
        }
        return items;
    }

    private List<ServiceItem> createServices(boolean isPpr, int offset) {
        List<ServiceItem> items = new ArrayList<>();
        for (int x = 0; x < statuses.size(); x++) {
            boolean activated = !statuses.get(x).equalsIgnoreCase("null");
            String status = activated ? statuses.get(x) : null;
            int id = x + offset;
            items.add(new ServiceItem(
                    String.valueOf(id),
                    "Name #" + id,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/ReichenbachBegin2.jpg/1600px-ReichenbachBegin2.jpg",
                    "http://provider.url.com",
                    "https://cdn.logo.com/hotlink-ok/logo-social.png",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                    activated,
                    isPpr,
                    status
            ));
        }
        if (isPpr) {
            int id = items.size() + offset + 10;
            items.add(new ServiceItem(
                    String.valueOf(id),
                    "Name #" + id,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/ReichenbachBegin2.jpg/1600px-ReichenbachBegin2.jpg",
                    "http://provider.url.com",
                    "https://cdn.logo.com/hotlink-ok/logo-social.png",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                    false,
                    false,
                    null
            ));
        }
        return items;
    }

    public ErrorDto activateDeactivateDataset(ActivateRq rq) {
        List<String> blockingActivationStatuses = statuses.subList(0, 3);
        String id = rq.getId();
        for (DatasetItem item : pcrDatasets) {
            if (!item.getId().equalsIgnoreCase(id)) continue;
            if (!rq.isActivated() && blockingActivationStatuses.contains(item.getStatus())) {
                return new ErrorDto("", "Cannot deactivate in status " + item.getStatus());
            }
            item.setActivated(rq.isActivated());
            return null;
        }
        for (DatasetItem item : pprDatasets) {
            if (!item.getId().equalsIgnoreCase(id)) continue;
            if (!rq.isActivated() && blockingActivationStatuses.contains(item.getStatus())) {
                return new ErrorDto("", "Cannot deactivate in status " + item.getStatus());
            }
            item.setActivated(rq.isActivated());
            return null;
        }
        for (ServiceItem item : pcrServices) {
            if (!item.getId().equalsIgnoreCase(id)) continue;
            if (!rq.isActivated() && blockingActivationStatuses.contains(item.getStatus())) {
                return new ErrorDto("", "Cannot deactivate in status " + item.getStatus());
            }
            item.setActivated(rq.isActivated());
            return null;
        }
        for (ServiceItem item : pprServices) {
            if (!item.getId().equalsIgnoreCase(id)) continue;
            if (!rq.isActivated() && blockingActivationStatuses.contains(item.getStatus())) {
                return new ErrorDto("", "Cannot deactivate in status " + item.getStatus());
            }
            item.setActivated(rq.isActivated());
            return null;
        }
        for (ServiceItem item : sp) {
            if (!item.getId().equalsIgnoreCase(id)) continue;
            if (!rq.isActivated() && blockingActivationStatuses.contains(item.getStatus())) {
                return new ErrorDto("", "Cannot deactivate in status " + item.getStatus());
            }
            item.setActivated(rq.isActivated());
            return null;
        }
        return new ErrorDto("", "no items with id '" + id + "' found");
    }
}
