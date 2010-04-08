otp.config = {
  
    'systemMap': {
        // If true, a system map will be used in the display
        enabled: false,

        // uris and layer names
        // these match up with geoserver
        layerUrlRoutes: 'http://routelayer.example.com/wms',
        layerUrlStops: 'http://stoplayer.example.com/wms',
        layerNamesRoute: 'routeLayerName',
        layerNamesStop: 'stopLayerName',
        
        // this is the uri to the extended api that proxies to geoserver
        controlStopsUrl: '/opentripplanner-api-extended/ws/wms'
    },
    
    'map': {
        // The default extent to zoom the map to when the web app loads.
        // This can either be an OpenLayers.Bounds object or the string "automatic"
        // If set to "automatic", the client will ask the server for the default extent.
        'defaultExtent': "automatic",
     
        // These options are passed directly to the OpenLayers.Map constructor.
        'options': {
            projection: "EPSG:4326",
            numZoomLevels: 17
        },
        
        // Base tile information 
        'baseLayerOptions': {
            url: 'http://maps.opengeo.org/geowebcache/service/wms',
            layers: ['openstreetmap'],
            format: 'image/png',
            transitionEffect: 'resize'
        }
    },

    // if specified, uri path to a custom logo
    // otherwise use the default "images/ui/logoSmall.png"
    'logo': null,
    
    // List of agency IDs (as specified in GTFS) for which custom icons should be used.
    // Icons should be placed in the custom directory (e.g., custom/nyct)
    // Ex. ['nyct', 'mnr']
    'useCustomIconsForAgencies': [],
    
    // Context menu with trip planning options (e.g., "Start trip here")
    plannerContextMenu : true,
    
    // Metrics system
    //metricsSystem : 'international', // => meters, km
    metricsSystem : 'english', // => feet, miles
    
    // Context menu with general map features (e.g., "Center map here")
    mapContextMenu : false

};