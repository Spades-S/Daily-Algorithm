/**
 * @param {string} IP
 * @return {string}
 */
var validIPAddress = function(IP) {
    if(IP.indexOf('.') >= 0){
        const IPV4s = IP.split('.');
        if(IPV4s.length !== 4) return 'Neither';
        const reg = /^[0-9]{1,3}$/;
    
        for(let item of IPV4s){
            if(!reg.test(item) || (+item) > 255 || (item[0] === '0' && item.length !== 1 )) return 'Neither';
        }
        return 'IPv4';
    }
    if(IP.indexOf(':') >= 0){
        const IPV6s = IP.split(':');
        if(IPV6s.length !== 8) return 'Neither';
        const reg = /^[0-9a-fA-F]{1,4}$/;
        for(let item of IPV6s){
            if(!reg.test(item)) return 'Neither';
        }
        
        return 'IPv6';
    }
    return 'Neither';
};