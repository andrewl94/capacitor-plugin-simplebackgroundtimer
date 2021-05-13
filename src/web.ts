import { WebPlugin } from '@capacitor/core';
import { SimpleBgTimerPlugin } from './definitions';

export class SimpleBgTimerWeb extends WebPlugin implements SimpleBgTimerPlugin {
  constructor() {
    super({
      name: 'SimpleBgTimer',
      platforms: ['web'],
    });
  }

  async startInterval(options: { interval: string }): Promise<{ value: boolean }> {
    console.log(options)
    return {value:true};
  }

  async stopInterval(options: { }): Promise<{ value: boolean }> {
    console.log(options)
    return {value:true};
  }

}

const SimpleBgTimer = new SimpleBgTimerWeb();

export { SimpleBgTimer };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(SimpleBgTimer);
