package by.grsu.smart.project.service.metal;

import by.grsu.smart.project.entity.Metal;
import by.grsu.smart.project.entity.MetalType;
import by.grsu.smart.project.parser.MetalDomParser;
import by.grsu.smart.project.parser.MetalTypeDomParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class MetalServiceImpl implements MetalService {
    private final static Logger logger = Logger.getLogger(MetalServiceImpl.class);
    private final static String METAL_COST_URL = "http://www.nbrb.by/Services/XmlIngots.aspx?onDate=";
    private final static String METAL_TYPE_URL = "http://www.nbrb.by/Services/XmlMetalsRef.aspx";


    @Autowired
    private MetalDomParser metalDomParser;

    @Autowired
    private MetalTypeDomParser metalTypeDomParser;

    @Override
    public List<Metal> getMetalCost() {
        logger.info("Start getting metal cost");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = simpleDateFormat.format(new Date());

        List<Metal> metals = metalDomParser.parse(METAL_COST_URL + formattedDate);
        List<MetalType> metalTypes = getMetalType();

        for (Metal metal : metals) {
            for (MetalType metalType: metalTypes) {
                if (Objects.equals(metal.getId(), metalType.getId())) {
                    metal.setMetalType(metalType);
                }
            }
        }

        return metals;
    }

    @Override
    public List<MetalType> getMetalType() {
        logger.info("Start getting metal type");

        return metalTypeDomParser.parse(METAL_TYPE_URL);
    }
}
