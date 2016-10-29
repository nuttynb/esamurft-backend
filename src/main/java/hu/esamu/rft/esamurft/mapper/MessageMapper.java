package hu.esamu.rft.esamurft.mapper;

import com.google.protobuf.ByteString;
import hu.esamu.rft.esamurft.dto.MessageDTO;
import hu.esamu.rft.esamurft.protos.EsamuRFTMessages;

/**
 * This is a utility class for converting EsamuRFTMessages protobuf class into persistable Data Transfer Objects, and backwards.
 */
public final class MessageMapper {
    private MessageMapper() {
    }

    public static MessageDTO mapToDto(EsamuRFTMessages.item message) {
        return new MessageDTO(message.getName(),
                message.getDescription(),
                message.getLatitude(),
                message.getLongitude(),
                message.getTimestamp(),
                message.getImage().toByteArray());
    }

    public static EsamuRFTMessages.item mapToProtobufClass(MessageDTO message) {
        return EsamuRFTMessages.item.newBuilder()
                .setName(message.getName())
                .setDescription(message.getDescription())
                .setLatitude(message.getLatitude())
                .setLongitude(message.getLongitude())
                .setTimestamp(message.getTimestamp())
                .setImage(ByteString.copyFrom(message.getImage()))
                .build();
    }
}
