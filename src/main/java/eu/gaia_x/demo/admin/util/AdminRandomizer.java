package eu.gaia_x.demo.admin.util;

import eu.gaia_x.demo.admin.dto.*;
import eu.gaia_x.demo.utils.JsonUtil;
import eu.gaia_x.demo.utils.MockData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;

@Slf4j
@Component
public class AdminRandomizer {

    //<editor-fold desc="Header">
    private final MockData mocks;
    private final Random random;

    private final List<Participant> participants;
    private final List<PartRequest> participantRequests;

    private final int id;

    public static Object PARTICIPANTS = new Object();
    public static Object REQUESTS = new Object();

    public AdminRandomizer() throws FileNotFoundException {
        this.mocks = JsonUtil.readJsonFromFile("mocks/discovery-mocks.json", MockData.class);
        this.random = new Random();
        this.participants = generateParticipants(random.ints(10, 100).findFirst().orElse(50));
        log.info("PART SIZE: " + participants.size());
        this.id = participants.size() + 10;
        this.participantRequests = generateRequests(random.ints(10, 100).findFirst().orElse(50));
    }
    //</editor-fold>

    //<editor-fold desc="Mocks">
    public List<Participant> getParticipants() {
        return participants;
    }

    public List<PartRequest> getParticipantRequests() {
        return participantRequests;
    }

    public PartRequest denyRequest(String id) {
        PartRequest item = null;
        for (int i = 0; i < participantRequests.size(); i++) {
            PartRequest participantRequest = participantRequests.get(i);
            if (participantRequest.getId().equalsIgnoreCase(id)) {
                item = participantRequest;
                participantRequests.remove(i);
                break;
            }
        }
        return item;
    }

    public void acceptRequest(PartRequest rq) {
        Participant participant = new Participant();
        participant.setParticipantName(rq.getParticipantName());
        participant.setLocation(rq.getLocation());
        participant.setId(rq.getId());
        participant.setRegistrationType(getRandomValueFromList(mocks.getRegistrationType()));
        participants.add(participant);
    }

    public FilterDto getFilterItems(boolean ifParticipants) {
        if (ifParticipants) {
            Map<String, Integer> type = getFilterItem(participants, Participant::getRegistrationType);
            return new FilterDto(FilterItem.createFilterItems(type));
        } else {
            Map<String, Integer> type = getFilterItem(participantRequests, PartRequest::getRequestType);
            return new FilterDto(FilterItem.createFilterItems(type));
        }
    }

    public LocationFilterDto getLocationFilterItems(boolean ifParticipants) {
        Map<String, Integer> location = new HashMap<>();
        if (ifParticipants) {
            location = getFilterItem(participants, Participant::getLocation);
        } else {
            location = getFilterItem(participantRequests, PartRequest::getLocation);
        }
        List<FilterItem> filterItems = FilterItem.createFilterItems(location);
        List<PrLocationFilterItem> items = new ArrayList<>();
        for (FilterItem filterItem : filterItems) {
            items.add(
                    new PrLocationFilterItem(
                            filterItem.getItemName(),
                            filterItem.getItemName(),
                            filterItem.getCount()
                    )
            );
        }
        return new LocationFilterDto(items);
    }

    public DetailsDto createDetails() {
        List<DetailsDto.SdData> sdDataList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(5) + 2; i++) {
            List<DetailsDto.Attribute> attributes = new ArrayList<>();
            for (int j = 0; j < random.nextInt(10) + 3; j++) {
                attributes.add(
                        new DetailsDto.Attribute(
                                "Attribute Name #" + j,
                                "Attribute Value #" + j,
                                random.nextBoolean()));
            }
            sdDataList.add(new DetailsDto.SdData("Category #" + i, attributes));
        }
        List<DetailsDto.AttachmentDto> attachments = new ArrayList<>();
//        for (int i = 0; i < random.nextInt(3) + 2; i++) {
//            attachments.add(
//                    new DetailsDto.AttachmentDto(
//                            "Attachment #" + i,
//                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
//                            "http://url.com"));
//        }
        return new DetailsDto(sdDataList, attachments);
    }
    //</editor-fold>

    //<editor-fold desc="Data Generation">
    private <T> Map<String, Integer> getFilterItem(List<T> lst, Function<T, String> filterFunc) {
        Map<String, Integer> set = new HashMap<>();
        for (T participant : lst) {
            String key = filterFunc.apply(participant);
            Integer count = set.getOrDefault(key, 0) + 1;
            set.put(key, count);
        }
        return set;
    }

    private <T> T getRandomValueFromList(List<T> lst) {
        if (lst.isEmpty()) throw new RuntimeException("Couldn't create mock data. Error 1001");
        if (lst.size() == 1) return lst.get(0);
        return lst.get(random.nextInt(lst.size()));
    }

    private List<PartRequest> generateRequests(int count) {
        List<PartRequest> lst = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PartRequest partRequest = new PartRequest(
                    String.valueOf(i + id),
                    getRandomValueFromList(mocks.getParticipantName()),
                    getRandomValueFromList(mocks.getLocationCountry()),
                    getRandomValueFromList(mocks.getRequestType()));
            lst.add(partRequest);
        }
        return lst;
    }

    private List<Participant> generateParticipants(int count) {
        log.info("COUNT: " + count);
        List<Participant> lst = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Participant participant = new Participant(
                    String.valueOf(i),
                    getRandomValueFromList(mocks.getParticipantName()),
                    getRandomValueFromList(mocks.getLocationCountry()),
                    getRandomValueFromList(mocks.getRegistrationType()));
            lst.add(participant);
        }
        return lst;
    }
    //</editor-fold>
}
