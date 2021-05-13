import { WebPlugin } from '@capacitor/core';
import { SimpleBgTimerPlugin } from './definitions';

export class SimpleBgTimerWeb extends WebPlugin implements SimpleBgTimerPlugin {
  constructor() {
    super({
      name: 'SimpleBgTimer',
      platforms: ['web'],
    });
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

const SimpleBgTimer = new SimpleBgTimerWeb();

export { SimpleBgTimer };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(SimpleBgTimer);
